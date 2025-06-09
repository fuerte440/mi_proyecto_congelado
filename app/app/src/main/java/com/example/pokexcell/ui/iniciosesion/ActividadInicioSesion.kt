package com.example.pokexcell.ui.iniciosesion

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.pokexcell.R
import com.example.pokexcell.data.dao.UsuarioDAO
import com.example.pokexcell.data.model.Usuario
import com.example.pokexcell.ui.menu.ActividadPrincipalMenu
import com.example.pokexcell.ui.registro.ActividadRegistro
import com.example.pokexcell.utils.HashUtils
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

@Suppress("DEPRECATION")
class ActividadInicioSesion : AppCompatActivity() {

    private lateinit var usuarioInput: EditText
    private lateinit var contrasenaInput: EditText
    private lateinit var botonIniciarSesion: Button
    private lateinit var botonSalir: Button
    private lateinit var crearCuenta: TextView
    private lateinit var icono: ImageView
    private lateinit var botonGoogle: Button

    private lateinit var usuarioDAO: UsuarioDAO
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_login)

        // Inicializar vistas
        usuarioInput = findViewById(R.id.username_input)
        contrasenaInput = findViewById(R.id.password_input)
        botonIniciarSesion = findViewById(R.id.login_button)
        botonSalir = findViewById(R.id.exit_button)
        crearCuenta = findViewById(R.id.create_account)
        icono = findViewById(R.id.app_icon)
        botonGoogle = findViewById(R.id.btnGoogleSignIn)

        usuarioDAO = UsuarioDAO(this)

        // Configurar Google Sign-In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        botonGoogle.setOnClickListener {
            val signInIntent = googleSignInClient.signInIntent
            googleSignInLauncher.launch(signInIntent)
        }

        // Inicio de sesión tradicional
        botonIniciarSesion.setOnClickListener {
            val usuario = usuarioInput.text.toString().trim()
            val contrasena = contrasenaInput.text.toString().trim()

            if (usuario.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val contrasenaCifrada = HashUtils.sha256(contrasena)
                val usuarioValido = usuarioDAO.iniciarSesion(usuario, contrasenaCifrada)

                if (usuarioValido != null) {
                    Toast.makeText(this, "Bienvenido, ${usuarioValido.nombre}", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, ActividadPrincipalMenu::class.java)
                    intent.putExtra("id_usuario", usuarioValido.id)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            }
        }

        botonSalir.setOnClickListener {
            finishAffinity()
        }

        crearCuenta.setOnClickListener {
            val intent = Intent(this, ActividadRegistro::class.java)
            startActivity(intent)
        }

        icono.setOnClickListener {
            Toast.makeText(this, "¡Soy PokExcel!", Toast.LENGTH_SHORT).show()
        }
    }

    private val googleSignInLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleSignInResult(task)
        } else {
            Toast.makeText(this, "Inicio de sesión cancelado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val email = account?.email
            val nombre = account?.displayName

            if (email != null) {
                var usuario = usuarioDAO.obtenerUsuarioPorEmail(email)

                if (usuario == null) {
                    val nuevoUsuario = Usuario(
                        id = 0,
                        nombre = nombre ?: "Usuario",
                        email = email,
                        contrasena = "google"
                    )

                    val creado = usuarioDAO.registrarUsuario2(nuevoUsuario)

                    if (creado) {
                        Toast.makeText(this, "Cuenta creada correctamente", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Error al crear la cuenta", Toast.LENGTH_SHORT).show()
                    }

                    usuario = usuarioDAO.obtenerUsuarioPorEmail(email)
                }

                usuario?.let {
                    Toast.makeText(this, "Bienvenido ${it.nombre}", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, ActividadPrincipalMenu::class.java)
                    intent.putExtra("id_usuario", it.id)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                } ?: run {
                    Toast.makeText(this, "Error al obtener el usuario", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Error: el email de Google es vacío", Toast.LENGTH_SHORT).show()
            }
        } catch (e: ApiException) {
            Toast.makeText(this, "Fallo al firmar con Google: ${e.statusCode}", Toast.LENGTH_SHORT).show()
        }
    }
}
