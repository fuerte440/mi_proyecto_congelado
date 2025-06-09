package com.example.pokexcell.ui.consultar

import android.os.Bundle
import android.util.Log
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_consultar_cartas_coleccion)

        spinner = findViewById(R.id.spinner_colecciones)
        recyclerView = findViewById(R.id.recycler_cartas_coleccion)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        idColeccion = intent.getIntExtra("id_coleccion", -1)
        idUsuario = intent.getIntExtra("id_usuario", -1)

        cartaDAO = CartaDAO(this)
        cartaListaDAO = CartaListaDAO(this)

        val todasLasCartas = cartaListaDAO.obtenerCartasPorColeccion(idColeccion)
        val idsCartasUsuario = cartaListaDAO.obtenerIdsCartasDeUsuarioPorColeccion(idUsuario, idColeccion)

        adapter = CartaColeccionAdapter(todasLasCartas, idsCartasUsuario)
        recyclerView.adapter = adapter

        val opciones = arrayOf(
            "Pokémon Card 151 2023" to 1,
            "Pokémon VStar Universe 2023" to 2
        )
        val nombres = opciones.map { it.first }
        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, nombres)
        spinner.adapter = adapterSpinner

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val idSeleccionado = opciones[position].second

                val cartasActualizadas = cartaListaDAO.obtenerCartasPorColeccion(idSeleccionado)
                val idsActualizados = cartaListaDAO.obtenerIdsCartasDeUsuarioPorColeccion(idUsuario, idSeleccionado)

                adapter = CartaColeccionAdapter(cartasActualizadas, idsActualizados)
                recyclerView.adapter = adapter
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        val botonVolver = findViewById<Button>(R.id.btn_volver_menu)
        botonVolver.setOnClickListener {
            finish() // Termina la actividad y vuelve al menú principal
        }
    }

}
