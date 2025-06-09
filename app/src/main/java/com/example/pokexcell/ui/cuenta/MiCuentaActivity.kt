@file:Suppress("DEPRECATION")

package com.example.pokexcell.ui.cuenta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.pokexcell.R
import com.example.pokexcell.data.dao.UsuarioDAO
import com.example.pokexcell.ui.menu.ActividadPrincipalMenu
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions


class MiCuentaActivity : AppCompatActivity() {

    private lateinit var editarEmail: EditText
    private lateinit var botonGuardar: Button
    private lateinit var botonEliminarCuenta: Button
    private lateinit var botonVolver: Button
    private lateinit var usuarioDAO: UsuarioDAO
    private var idUsuario: Int = -1
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_mi_cuenta)
        idUsuario = intent.getIntExtra("id_usuario", -1)
        usuarioDAO = UsuarioDAO(this)

        val nombreUsuario = usuarioDAO.obtenerNombreUsuario(idUsuario)
        val emailUsuario = usuarioDAO.obtenerEmail(idUsuario)

        val textoInfo = "Nombre de usuario: $nombreUsuario"
        findViewById<TextView>(R.id.tv_info_usuario).text = textoInfo
        val textoInfo2 = "Cuenta de email: $emailUsuario"
        findViewById<TextView>(R.id.tv_info_email).text = textoInfo2
        // Inicializar GoogleSignInClient
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        editarEmail = findViewById(R.id.editar_email)
        botonGuardar = findViewById(R.id.boton_guardar_email)
        botonVolver = findViewById(R.id.btn_volver_menu)
        botonEliminarCuenta = findViewById(R.id.btn_eliminar_cuenta)

        idUsuario = intent.getIntExtra("id_usuario", -1)
        usuarioDAO = UsuarioDAO(this)

        botonGuardar.setOnClickListener {
            val nuevoEmail = editarEmail.text.toString().trim()

            val contrasenaUsuario = usuarioDAO.obtenerContrasena(idUsuario) // 'google' para cuentas Google

            if (contrasenaUsuario == "google") {
                Toast.makeText(this, "No puedes cambiar el email de una cuenta de Google", Toast.LENGTH_SHORT).show()
            } else {
                if (nuevoEmail.isNotEmpty() && validarEmail(nuevoEmail)) {
                    val actualizado = usuarioDAO.actualizarEmail(idUsuario, nuevoEmail)
                    if (actualizado) {
                        Toast.makeText(this, "Email actualizado correctamente", Toast.LENGTH_SHORT).show()
                        volverAlMenu()
                    } else {
                        Toast.makeText(this, "Error al actualizar el email", Toast.LENGTH_SHORT).show()
                    }
                } else if (nuevoEmail.isEmpty()) {
                    Toast.makeText(this, "Introduce un correo válido", Toast.LENGTH_SHORT).show()
                }
            }
        }



        botonEliminarCuenta.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Eliminar Cuenta")
                .setMessage("¿Estás seguro de que quieres eliminar tu cuenta? Esta acción no se puede deshacer.")
                .setPositiveButton("Sí") { _, _ ->
                    val eliminado = usuarioDAO.eliminarUsuario(idUsuario)
                    if (eliminado) {
                        Toast.makeText(this, "Cuenta eliminada correctamente", Toast.LENGTH_SHORT).show()

                        // Cerrar sesión Google antes de redirigir
                        mGoogleSignInClient.signOut().addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                redirigirAlLogin()
                            } else {
                                Toast.makeText(this, "Error al cerrar sesión de Google", Toast.LENGTH_SHORT).show()
                                redirigirAlLogin() // igual redirigimos para no bloquear la app
                            }
                        }
                    } else {
                        Toast.makeText(this, "Error al eliminar cuenta", Toast.LENGTH_SHORT).show()
                    }
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }



        botonVolver.setOnClickListener {
            volverAlMenu()
        }
    }
    private fun validarEmail(email: String): Boolean {
        // Validación simple basada en dominios permitidos (como en tu ejemplo)
        val emailValido = email.endsWith("@gmail.com") || email.endsWith("@gmail.es") ||
                email.endsWith("@hotmail.com") || email.endsWith("@hotmail.es")

        if (!emailValido) {
            Toast.makeText(
                this,
                "El email debe ser @gmail.com/.es o @hotmail.com/.es",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }
        return true
    }

    private fun volverAlMenu() {
        val intent = Intent(this, ActividadPrincipalMenu::class.java)
        intent.putExtra("id_usuario", idUsuario)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    private fun redirigirAlLogin() {
        val intent = Intent(this, com.example.pokexcell.ui.iniciosesion.ActividadInicioSesion::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
