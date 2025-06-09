package com.example.pokexcell.ui.consultar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokexcell.R
import com.example.pokexcell.data.dao.CartaListaDAO
import com.example.pokexcell.data.dao.ListaDAO
import com.example.pokexcell.data.dao.UsuarioDAO
import com.example.pokexcell.data.model.Lista
import com.example.pokexcell.ui.ExportadorExcel.ExportadorExcel
import com.example.pokexcell.ui.adapters.ListaAdapter
import com.example.pokexcell.ui.enviarCorreo.EnviarCorreo

class ActividadConsultarListas : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var coleccionAdapter: ListaAdapter
    private lateinit var listaDAO: ListaDAO
    private lateinit var cartaListaDAO: CartaListaDAO
    private lateinit var usuarioDAO: UsuarioDAO
    private var idUsuario: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_consultar_listas)

        idUsuario = intent.getIntExtra("id_usuario", -1)

        usuarioDAO = UsuarioDAO(this)
        cartaListaDAO = CartaListaDAO(this)
        listaDAO = ListaDAO(this)

        recyclerView = findViewById(R.id.recycler_colecciones)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Carga inicial de listas
        val coleccionesDelUsuario: List<Lista> = listaDAO.obtenerColeccionesDeUsuario(idUsuario)

        coleccionAdapter = ListaAdapter(
            listasDelUsuario = coleccionesDelUsuario,
            onItemClick = { lista ->
                val intent = Intent(this, ActividadConsultarCartasEnListas::class.java)
                intent.putExtra("id_lista", lista.id_lista)
                intent.putExtra("idColeccion", lista.id_coleccion)
                startActivity(intent)
            },
            onExportClick = { lista ->
                val cartas = cartaListaDAO.obtenerCartasPorLista(lista.id_lista)
                ExportadorExcel.exportarLista(this, cartas)
            },
            onSendEmailClick = { lista ->
                Toast.makeText(this, "Danos unos segundos, estamos generando tu archivo Excel...", Toast.LENGTH_SHORT).show()
                enviarCorreoConLista(lista)
            }
        )

        recyclerView.adapter = coleccionAdapter

        val btnVolverMenu = findViewById<Button>(R.id.btn_volver_menu)
        btnVolverMenu.setOnClickListener {
            finish()
        }
    }


    override fun onResume() {
        super.onResume()
        val coleccionesActualizadas = listaDAO.obtenerColeccionesDeUsuario(idUsuario)
        coleccionAdapter.actualizarListas(coleccionesActualizadas)
    }



    private fun enviarCorreoConLista(lista: Lista) {
        val cartas = cartaListaDAO.obtenerCartasPorLista(lista.id_lista)
        val emailUsuario = usuarioDAO.obtenerEmail(idUsuario)

        if (cartas.isNotEmpty() && emailUsuario.isNotEmpty()) {
            EnviarCorreo.exportarListaYEnviarPorCorreo(this, cartas, emailUsuario)
        } else {
            Toast.makeText(this, "No se pudo obtener datos para enviar el correo", Toast.LENGTH_SHORT).show()
        }
    }
}
