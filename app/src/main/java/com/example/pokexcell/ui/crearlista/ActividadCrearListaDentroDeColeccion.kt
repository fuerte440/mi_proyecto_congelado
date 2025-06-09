package com.example.pokexcell.ui.crearlista

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokexcell.R
import com.example.pokexcell.data.dao.CartaDAO
import com.example.pokexcell.data.dao.CartaListaDAO
import com.example.pokexcell.data.db.PokexcelDBHelper
import com.example.pokexcell.data.model.Carta
import com.example.pokexcell.data.model.CartaConCantidad
import com.example.pokexcell.ui.ExportadorExcel.ExportadorExcel
import com.example.pokexcell.ui.adapters.CartaAdapter

class ActividadCrearListaDentroDeColeccion : AppCompatActivity() {

    private lateinit var editBuscarNumero: EditText
    private lateinit var botonBuscar: Button
    private lateinit var recyclerCartas: RecyclerView
    private lateinit var totalCartasTextView: TextView
    private lateinit var cartaDAO: CartaDAO
    private lateinit var adapter: CartaAdapter
    private val cartasLista = mutableListOf<CartaConCantidad>()
    private lateinit var cartaListaDAO: CartaListaDAO
    private var idColeccion: Int = -1
    private var idLista: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContentView(R.layout.actividad_crear_lista_dentro_de_coleccion)

        idColeccion = intent.getIntExtra("id_coleccion", -1)
        idLista = intent.getIntExtra("id_lista", -1)

        editBuscarNumero = findViewById(R.id.edit_buscar_numero)
        botonBuscar = findViewById(R.id.boton_buscar_carta)
        recyclerCartas = findViewById(R.id.recycler_cartas_lista)
        totalCartasTextView = findViewById(R.id.text_total_cartas)

        this@ActividadCrearListaDentroDeColeccion.cartaDAO = CartaDAO(this)
        cartaListaDAO = CartaListaDAO(this) // ← IMPORTANTE

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

        val botonGuardar = findViewById<Button>(R.id.boton_guardar)
        botonGuardar.setOnClickListener {
            Toast.makeText(this, "Colección guardada correctamente", Toast.LENGTH_SHORT).show()
            finish()
        }

        val botonExportar = findViewById<Button>(R.id.boton_exportar)
        botonExportar.setOnClickListener {
            ExportadorExcel.exportarLista(this, cartasLista)
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
        val inicio = cartasLista.size // tamaño actual antes de cargar
        while (cursor.moveToNext()) {
            val carta = Carta(
                id_carta = cursor.getInt(cursor.getColumnIndexOrThrow("id_carta")),
                nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
                coleccion = cursor.getString(cursor.getColumnIndexOrThrow("coleccion")),
                fecha_lanzamiento = cursor.getString(cursor.getColumnIndexOrThrow("fecha_lanzamiento")),
                numero_carta = cursor.getString(cursor.getColumnIndexOrThrow("numero_carta")),
                rareza = cursor.getString(cursor.getColumnIndexOrThrow("rareza")),
                url_imagen = cursor.getString(cursor.getColumnIndexOrThrow("url_imagen")),
                id_coleccion = cursor.getInt(cursor.getColumnIndexOrThrow("id_coleccion"))
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


     fun buscarYAgregarCarta(numeroCarta: String) {
        val carta = cartaDAO.obtenerCartaPorNumero(numeroCarta, idColeccion)
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
            // Ya existe en la lista, se actualiza la cantidad
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
            // No existe, insertar con cantidad 1
            val values = ContentValues().apply {
                put("id_lista", idLista)
                put("id_carta", carta.id_carta)
                put("cantidad", 1)
            }
            db.insert("carta_lista", null, values)

            // Añadir al principio de la lista
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
