package com.example.pokexcell.ui.consultar

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokexcell.R
import com.example.pokexcell.data.dao.CartaDAO
import com.example.pokexcell.data.dao.CartaListaDAO
import com.example.pokexcell.data.db.PokexcelDBHelper
import com.example.pokexcell.data.model.Carta
import com.example.pokexcell.data.model.CartaConCantidad
import com.example.pokexcell.ui.adapters.CartaAdapter

class ActividadConsultarCartasEnListas : AppCompatActivity() {

    private lateinit var editBuscarNumero: EditText
    private lateinit var botonBuscar: Button
    private lateinit var recyclerCartas: RecyclerView
    private lateinit var totalCartasTextView: TextView
    private lateinit var cartaDAO: CartaDAO
    private lateinit var adapter: CartaAdapter
    private val cartasLista = mutableListOf<CartaConCantidad>()
    private lateinit var cartaListaDAO: CartaListaDAO
    private var idLista: Int = -1
    private var idColeccion: Int = -1

    @SuppressLint("NotifyDataSetChanged", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_modificar_lista_dentro_de_coleccion)

        idLista = intent.getIntExtra("id_lista", -1)
        idColeccion = intent.getIntExtra("idColeccion", -1)
        editBuscarNumero = findViewById(R.id.edit_buscar_numero2)
        botonBuscar = findViewById(R.id.boton_buscar_carta2)
        recyclerCartas = findViewById(R.id.recycler_cartas_lista)
        totalCartasTextView = findViewById(R.id.text_total_cartas2)

        cartaDAO = CartaDAO(this)
        cartaListaDAO = CartaListaDAO(this)

        adapter = CartaAdapter(cartasLista) { cartaConCantidad, nuevaCantidad ->
            actualizarCantidadEnBD(cartaConCantidad, nuevaCantidad)
        }

        recyclerCartas.layoutManager = LinearLayoutManager(this)
        recyclerCartas.adapter = adapter

        botonBuscar.setOnClickListener {
            val numeroBuscado = editBuscarNumero.text.toString().trim()
            if (numeroBuscado.isNotEmpty()) {
                buscarYAgregarCarta(numeroBuscado)
            }
        }

        cargarCartasDeLista()

        findViewById<Button>(R.id.boton_guardar2).setOnClickListener {
            Toast.makeText(this, "Lista guardada correctamente", Toast.LENGTH_SHORT).show()
            finish()
        }

        findViewById<Button>(R.id.boton_eliminar).setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Eliminar Lista")
                .setMessage("¿Estás seguro de que quieres eliminar la lista?")
                .setPositiveButton("Sí") { _, _ ->
                    // Eliminar de la base de datos
                    cartaListaDAO.eliminarListaDeCartas(idLista)

                    // Vaciar la lista en memoria
                    cartasLista.clear()

                    // Actualizar el adaptador
                    adapter.notifyDataSetChanged()

                    // Actualizar el texto de total de cartas
                    totalCartasTextView.text = "Cartas en la lista: 0"

                    Toast.makeText(this, "Lista eliminada correctamente", Toast.LENGTH_SHORT).show()


                    finish()
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }



    }

    private fun cargarCartasDeLista() {
        val db = PokexcelDBHelper(this).readableDatabase
        val query = """
            SELECT c.*, cl.cantidad FROM carta c
            INNER JOIN carta_lista cl ON c.id_carta = cl.id_carta
            WHERE cl.id_lista = ?
        """

        val cursor = db.rawQuery(query, arrayOf(idLista.toString()))
        val inicio = cartasLista.size

        while (cursor.moveToNext()) {
            val carta = Carta(
                id_carta = cursor.getInt(cursor.getColumnIndexOrThrow("id_carta")),
                nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
                coleccion = cursor.getString(cursor.getColumnIndexOrThrow("coleccion")),
                fecha_lanzamiento = cursor.getString(cursor.getColumnIndexOrThrow("fecha_lanzamiento")),
                numero_carta = cursor.getString(cursor.getColumnIndexOrThrow("numero_carta")),
                rareza = cursor.getString(cursor.getColumnIndexOrThrow("rareza")),
                url_imagen = cursor.getString(cursor.getColumnIndexOrThrow("url_imagen")),
                dibujante = cursor.getString(cursor.getColumnIndexOrThrow("dibujante"))
            )
            val cantidad = cursor.getInt(cursor.getColumnIndexOrThrow("cantidad"))
            cartasLista.add(CartaConCantidad(carta, cantidad))
        }

        val cantidadInsertada = cartasLista.size - inicio

        cursor.close()
        db.close()

        if (cantidadInsertada > 0) {
            adapter.notifyItemRangeInserted(inicio, cantidadInsertada)
        }

        actualizarTotalCartas()
    }

    private fun buscarYAgregarCarta(numeroCarta: String) {
        // Ahora no filtramos por colección, buscamos la carta solo por número
        val carta = cartaDAO.obtenerCartaPorNumero(numeroCarta,idColeccion)
        if (carta == null) {
            Toast.makeText(this, "No se ha encontrado ninguna carta con ese número.", Toast.LENGTH_SHORT).show()
            return
        }

        val db = PokexcelDBHelper(this).writableDatabase
        val cursor = db.rawQuery(
            "SELECT cantidad FROM carta_lista WHERE id_lista = ? AND id_carta = ?",
            arrayOf(idLista.toString(), carta.id_carta.toString())
        )

        if (cursor.moveToFirst()) {
            // Ya existe en la lista, actualizamos la cantidad
            val cantidadActual = cursor.getInt(cursor.getColumnIndexOrThrow("cantidad"))
            val nuevaCantidad = cantidadActual + 1

            val values = ContentValues().apply {
                put("cantidad", nuevaCantidad)
            }

            db.update(
                "carta_lista",
                values,
                "id_lista = ? AND id_carta = ?",
                arrayOf(idLista.toString(), carta.id_carta.toString())
            )

            // Actualizar visualmente
            val index = cartasLista.indexOfFirst { it.carta.id_carta == carta.id_carta }
            if (index != -1) {
                cartasLista[index].cantidad = nuevaCantidad
                adapter.notifyItemChanged(index)
            }

        } else {
            // No existe, insertamos con cantidad 1
            val values = ContentValues().apply {
                put("id_lista", idLista)
                put("id_carta", carta.id_carta)
                put("cantidad", 1)
            }
            db.insert("carta_lista", null, values)

            // Añadimos al principio de la lista
            cartasLista.add(0, CartaConCantidad(carta, 1))
            adapter.notifyItemInserted(0)
            recyclerCartas.scrollToPosition(0)
        }

        cursor.close()
        db.close()
        actualizarTotalCartas()
    }

    private fun actualizarCantidadEnBD(cartaConCantidad: CartaConCantidad, nuevaCantidad: Int) {
        val db = PokexcelDBHelper(this).writableDatabase

        if (nuevaCantidad == 0) {
            // Eliminar de la base de datos
            db.delete(
                "carta_lista",
                "id_lista = ? AND id_carta = ?",
                arrayOf(idLista.toString(), cartaConCantidad.carta.id_carta.toString())
            )

            // Eliminar de la lista y notificar al adapter
            val index = cartasLista.indexOfFirst { it.carta.id_carta == cartaConCantidad.carta.id_carta }
            if (index != -1) {
                cartasLista.removeAt(index)
                adapter.notifyItemRemoved(index)
            }
        } else {
            // Actualizar cantidad si nuevaCantidad > 0
            val values = ContentValues().apply {
                put("cantidad", nuevaCantidad)
            }
            db.update(
                "carta_lista",
                values,
                "id_lista = ? AND id_carta = ?",
                arrayOf(idLista.toString(), cartaConCantidad.carta.id_carta.toString())
            )
            cartaConCantidad.cantidad = nuevaCantidad

            val index = cartasLista.indexOfFirst { it.carta.id_carta == cartaConCantidad.carta.id_carta }
            if (index != -1) {
                adapter.notifyItemChanged(index)
            }
        }

        db.close()
        actualizarTotalCartas()
    }


    private fun actualizarTotalCartas() {
        val total = cartasLista.sumOf { it.cantidad }
        totalCartasTextView.text = getString(R.string.cantidad_carta, total)
    }
}
