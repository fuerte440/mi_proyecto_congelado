package com.example.pokexcell.ui.registro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pokexcell.R
import com.example.pokexcell.data.dao.UsuarioDAO
import com.example.pokexcell.data.model.Usuario
import com.example.pokexcell.ui.iniciosesion.ActividadInicioSesion
import com.example.pokexcell.utils.HashUtils

class ActividadRegistro : AppCompatActivity() {

    private lateinit var campoUsuario: EditText
    private lateinit var campoEmail: EditText
    private lateinit var campoContrasena: EditText
    private lateinit var campoConfirmarContrasena: EditText
    private lateinit var botonRegistrar: Button
    private lateinit var botonSalir: Button

    private lateinit var usuarioDAO: UsuarioDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_registro)

        campoUsuario = findViewById(R.id.registro_nombre)
        campoEmail = findViewById(R.id.registro_email)
        campoContrasena = findViewById(R.id.registro_contrasena)
        campoConfirmarContrasena = findViewById(R.id.registro_confirmar_contrasena)
        botonRegistrar = findViewById(R.id.boton_registrarse)
        botonSalir = findViewById(R.id.boton_salir)

        usuarioDAO = UsuarioDAO(this)

        botonRegistrar.setOnClickListener {
            val nombre = campoUsuario.text.toString().trim()
            val email = campoEmail.text.toString().trim()
            val contrasena = campoContrasena.text.toString().trim()
            val confirmar = campoConfirmarContrasena.text.toString().trim()

            if (nombre.isEmpty() || email.isEmpty() || contrasena.isEmpty() || confirmar.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            } else if (contrasena != confirmar) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            } else if (!validarCredenciales(nombre, contrasena, email)) {
                // Mensajes ya se muestran dentro de la función
            } else {
                val contrasenaCifrada = HashUtils.sha256(contrasena)
                val nuevoUsuario =
                    Usuario(nombre = nombre, email = email, contrasena = contrasenaCifrada)

                val exito = usuarioDAO.registrarUsuario2(nuevoUsuario)

                if (exito) {
                    Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    //el short dura 2 s el long 3.5
                    Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show()
                }
            }
        }

        botonSalir.setOnClickListener {
            val intent = Intent(this, ActividadInicioSesion::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }

    private fun validarCredenciales(usuario: String, contrasena: String, email: String): Boolean {
        val usuarioValido = usuario.length in 6..14
        val contrasenaValida = contrasena.length >= 6 && contrasena.contains(Regex("[^a-zA-Z0-9]"))
        val emailValido = email.endsWith("@gmail.com") || email.endsWith("@gmail.es") ||
                email.endsWith("@hotmail.com") || email.endsWith("@hotmail.es")

        if (!usuarioValido) {
            Toast.makeText(
                this,
                "El nombre de usuario debe tener entre 6 y 14 caracteres",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        if (!contrasenaValida) {
            Toast.makeText(
                this,
                "La contraseña debe tener al menos 6 caracteres y un carácter especial",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        if (!emailValido) {
            Toast.makeText(
                this,
                "El email debe terminar en @gmail.com/.es o @hotmail.com/.es",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        return true
    }
}

