package com.example.pokexcell.ui.consultar

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokexcell.R
import com.example.pokexcell.data.dao.CartaDAO
import com.example.pokexcell.data.dao.CartaListaDAO
import com.example.pokexcell.ui.adapters.CartaColeccionAdapter

class ActividadConsultarCartasDeColeccion : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CartaColeccionAdapter
    private lateinit var cartaDAO: CartaDAO
    private lateinit var cartaListaDAO: CartaListaDAO
    private var idColeccion: Int = -1
    private var idUsuario: Int = -1
    private lateinit var spinner: Spinner
    private lateinit var spinnerLista: Spinner

    // 👇 Variables auxiliares para controlar selección actual
    private var idColeccionSeleccionada = -1
    private var nombreListaSeleccionada = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_consultar_cartas_coleccion)

        spinner = findViewById(R.id.spinner_colecciones)
        spinnerLista = findViewById(R.id.spinner_listas)
        recyclerView = findViewById(R.id.recycler_cartas_coleccion)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        idColeccion = intent.getIntExtra("id_coleccion", -1)
        idUsuario = intent.getIntExtra("id_usuario", -1)

        cartaDAO = CartaDAO(this)
        cartaListaDAO = CartaListaDAO(this)

        // 👉 Adaptador y RecyclerView inicial (sin filtro por lista aún)
        val todasLasCartas = cartaListaDAO.obtenerCartasPorColeccion(idColeccion)
        val idsCartasUsuario = cartaListaDAO.obtenerIdsCartasDeUsuarioPorColeccion(idUsuario, idColeccion)

        adapter = CartaColeccionAdapter(todasLasCartas, idsCartasUsuario)
        recyclerView.adapter = adapter

        // 👉 Spinner de colecciones
        val opciones = arrayOf(
            "Pokémon Card 151 2023" to 1,
            "Pokémon VStar Universe 2023" to 2
        )
        val nombres = opciones.map { it.first }
        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, nombres)
        spinner.adapter = adapterSpinner

        idColeccionSeleccionada = opciones[0].second // valor inicial

        // 👉 Spinner de listas del usuario
        val listasUsuario = cartaListaDAO.obtenerListasDeUsuario(idUsuario)
        val nombresListas = listasUsuario.map { it.nombre_lista }
        val adapterListas = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, nombresListas)
        spinnerLista.adapter = adapterListas

        if (nombresListas.isNotEmpty()) {
            nombreListaSeleccionada = nombresListas[0]
        }

        // 👉 Evento cuando se selecciona colección
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                idColeccionSeleccionada = opciones[position].second
                filtrarCartas()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // 👉 Evento cuando se selecciona lista
        spinnerLista.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                nombreListaSeleccionada = nombresListas[position]
                filtrarCartas()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        val botonVolver = findViewById<Button>(R.id.btn_volver_menu)
        botonVolver.setOnClickListener {
            finish()
        }
    }

    // ✅ Esta función filtra las cartas por colección y lista seleccionadas
    private fun filtrarCartas() {
        val lista = cartaListaDAO.obtenerListaPorNombreYUsuario(nombreListaSeleccionada, idUsuario) ?: return
        val idsCartasDeLista = cartaListaDAO.obtenerIdsCartasPorLista(lista.id_lista)

        val cartas = cartaListaDAO.obtenerCartasPorColeccion(idColeccionSeleccionada)
        adapter = CartaColeccionAdapter(cartas, idsCartasDeLista)
        recyclerView.adapter = adapter
    }
}
