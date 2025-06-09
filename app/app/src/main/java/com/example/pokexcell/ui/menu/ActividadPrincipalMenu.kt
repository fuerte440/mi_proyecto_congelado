@file:Suppress("DEPRECATION")

package com.example.pokexcell.ui.menu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pokexcell.R
import com.example.pokexcell.ui.colecciones.CrearColeccionActivity
import com.example.pokexcell.ui.consultar.ActividadConsultarCartasDeColeccion
import com.example.pokexcell.ui.consultar.ActividadConsultarListas
import com.example.pokexcell.ui.cuenta.MiCuentaActivity
import com.example.pokexcell.ui.iniciosesion.ActividadInicioSesion
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class ActividadPrincipalMenu : AppCompatActivity() {

    private var idUsuario: Int = -1
    private lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_principal_menu)

        // Obtener el ID del usuario que inició sesión
        idUsuario = intent.getIntExtra("id_usuario", -1)

        val botonMiCuenta = findViewById<Button>(R.id.boton_mi_cuenta)
        val botonConsultar = findViewById<Button>(R.id.boton_consultar)
        val botonCrear = findViewById<Button>(R.id.boton_crear)
        val botonSalir = findViewById<Button>(R.id.boton_salir)
        val botonConsultarCartasColeccion = findViewById<Button>(R.id.boton_consultar_cartas_coleccion)

        // Configurar GoogleSignInClient con opciones por defecto (solo email)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        botonMiCuenta.setOnClickListener {
            val intent = Intent(this, MiCuentaActivity::class.java)
            intent.putExtra("id_usuario", idUsuario)
            startActivity(intent)
        }

        botonConsultar.setOnClickListener {
            val intent = Intent(this, ActividadConsultarListas::class.java)
            intent.putExtra("id_usuario", idUsuario)
            startActivity(intent)
        }

        botonCrear.setOnClickListener {
            if (idUsuario != -1) {
                val intent = Intent(this, CrearColeccionActivity::class.java)
                intent.putExtra("id_usuario", idUsuario)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Error: usuario no identificado", Toast.LENGTH_SHORT).show()
            }
        }
        botonConsultarCartasColeccion.setOnClickListener {
            val intent = Intent(this, ActividadConsultarCartasDeColeccion::class.java)
            // Aquí debes pasar id_coleccion e id_usuario que se requieren en la actividad
            intent.putExtra("id_coleccion", 1)  // Cambia este 1 por el valor real que quieres enviar
            intent.putExtra("id_usuario", idUsuario)    // Cambia este 1 por el valor real que quieres enviar
            startActivity(intent)
        }
        botonSalir.setOnClickListener {
            // Solo cerrar sesión de Google Sign-In (sin Firebase)
            mGoogleSignInClient.signOut().addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Sesión cerrada correctamente", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, ActividadInicioSesion::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Error al cerrar sesión de Google", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
