package com.example.pokexcell.ui.colecciones

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pokexcell.R
import com.example.pokexcell.data.db.PokexcelDBHelper
import com.example.pokexcell.ui.crearlista.ActividadCrearListaDentroDeColeccion
import com.example.pokexcell.ui.menu.ActividadPrincipalMenu

class CrearColeccionActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var editNombre: EditText
    private lateinit var botonGuardar: Button
    private lateinit var botonCancelar: Button
    private lateinit var dbHelper: PokexcelDBHelper
    private lateinit var imageViewColeccion: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_crear_coleccion)

        spinner = findViewById(R.id.spinner_colecciones)
        editNombre = findViewById(R.id.edit_nombre_personalizado)
        botonGuardar = findViewById(R.id.boton_guardar_coleccion)
        botonCancelar = findViewById(R.id.boton_cancelar)
        imageViewColeccion = findViewById(R.id.imageViewColeccion)
        imageViewColeccion.visibility = View.GONE

        dbHelper = PokexcelDBHelper(this)

        // Obtener el ID del usuario desde el Intent
        val idUsuario = intent.getIntExtra("id_usuario", -1)

        val opciones = arrayOf(
            "Pokémon Card 151 2023",
            "Pokémon VStar Universe 2023"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, opciones)
        spinner.adapter = adapter

        // Mostrar imagen al seleccionar una colección
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val coleccionSeleccionada = parent.getItemAtPosition(position).toString()

                val db = dbHelper.readableDatabase
                val cursor = db.rawQuery(
                    "SELECT imagen_url FROM coleccion WHERE nombre_coleccion = ?",
                    arrayOf(coleccionSeleccionada)
                )

                if (cursor.moveToFirst()) {
                    val imagenUrl = cursor.getString(0)

                    imageViewColeccion.visibility = View.VISIBLE

                    Glide.with(this@CrearColeccionActivity)
                        .load(imagenUrl)
                        .into(imageViewColeccion)
                }

                cursor.close()
                db.close()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        botonGuardar.setOnClickListener {
            val nombrePersonalizado = editNombre.text.toString().trim()
            val coleccionSeleccionada = spinner.selectedItem.toString()

            if (nombrePersonalizado.isEmpty()) {
                Toast.makeText(this, "Introduce un nombre para la colección", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (idUsuario == -1) {
                Toast.makeText(this, "Error al obtener usuario", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val db = dbHelper.writableDatabase

            // Verificar si ya existe una lista con ese nombre para ese usuario
            val cursor = db.rawQuery(
                "SELECT id_lista FROM lista WHERE nombre_lista = ? AND id_usuario = ?",
                arrayOf(nombrePersonalizado, idUsuario.toString())
            )

            if (cursor.moveToFirst()) {
                Toast.makeText(this, "Ya existe una lista con ese nombre", Toast.LENGTH_SHORT).show()
                cursor.close()
                return@setOnClickListener
            }
            cursor.close()

            // Obtener el ID de la colección base seleccionada
            val cursorColeccion = db.rawQuery(
                "SELECT id_coleccion FROM coleccion WHERE nombre_coleccion = ?",
                arrayOf(coleccionSeleccionada)
            )
            var idColeccionBase: Int? = null
            if (cursorColeccion.moveToFirst()) {
                idColeccionBase = cursorColeccion.getInt(0)
            }
            cursorColeccion.close()

            if (idColeccionBase == null) {
                Toast.makeText(this, "La colección base no existe en la base de datos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Insertar nueva lista personalizada
            val valuesLista = ContentValues().apply {
                put("nombre_lista", nombrePersonalizado)
                put("id_usuario", idUsuario)
                put("id_coleccion", idColeccionBase)  // Aquí agregamos el id_coleccion obtenido antes
            }

            val idLista = db.insert("lista", null, valuesLista)

            if (idLista != -1L) {
                Toast.makeText(this, "Lista creada correctamente", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ActividadCrearListaDentroDeColeccion::class.java)
                intent.putExtra("id_coleccion", idColeccionBase)
                intent.putExtra("id_lista", idLista.toInt())
                intent.putExtra("id_usuario", idUsuario)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Error al crear la lista", Toast.LENGTH_SHORT).show()
            }
        }

        botonCancelar.setOnClickListener {
            val intent = Intent(this, ActividadPrincipalMenu::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.putExtra("id_usuario", idUsuario)
            startActivity(intent)
        }
    }
}
