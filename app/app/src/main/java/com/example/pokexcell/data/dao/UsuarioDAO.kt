package com.example.pokexcell.data.dao

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import com.example.pokexcell.data.db.PokexcelDBHelper
import com.example.pokexcell.data.model.Usuario

class UsuarioDAO(context: Context) {

    private val dbHelper = PokexcelDBHelper(context)


    // Registro normal con nombre, email y contraseña
    fun registrarUsuario2(usuario: Usuario): Boolean {
        val db = dbHelper.writableDatabase
        val nombreLimpio = usuario.nombre.trim().lowercase()
        val emailLimpio = usuario.email.trim().lowercase()

        val cursorEmail = db.rawQuery(
            "SELECT * FROM usuarios WHERE LOWER(TRIM(email)) = ?",
            arrayOf(emailLimpio)
        )
        if (cursorEmail.moveToFirst()) {
            cursorEmail.close()
            db.close()
            return false
        }
        cursorEmail.close()

        val cursorNombre = db.rawQuery(
            "SELECT * FROM usuarios WHERE LOWER(TRIM(nombre)) = ?",
            arrayOf(nombreLimpio)
        )
        if (cursorNombre.moveToFirst()) {
            cursorNombre.close()
            db.close()
            return false
        }
        cursorNombre.close()

        val values = ContentValues().apply {
            put("nombre", nombreLimpio)
            put("email", emailLimpio)
            put("contrasena", usuario.contrasena)
        }

        val resultado = db.insert("usuarios", null, values)
        db.close()

        return resultado != -1L
    }

    fun iniciarSesion(nombreUsuario: String, contrasena: String): Usuario? {
        val db = dbHelper.readableDatabase
        val nombreLimpio = nombreUsuario.trim().lowercase()

        val query = "SELECT * FROM usuarios WHERE LOWER(TRIM(nombre)) = ? AND contrasena = ?"
        val cursor = db.rawQuery(query, arrayOf(nombreLimpio, contrasena))

        var usuario: Usuario? = null
        if (cursor.moveToFirst()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id_usuario"))
            val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
            val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
            val pass = cursor.getString(cursor.getColumnIndexOrThrow("contrasena"))

            usuario = Usuario(id, nombre, email, pass)
        }

        cursor.close()
        db.close()
        return usuario
    }

    fun actualizarEmail(idUsuario: Int, nuevoEmail: String): Boolean {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("email", nuevoEmail.trim())
        }
        val result = db.update("usuarios", values, "id_usuario = ?", arrayOf(idUsuario.toString()))
        db.close()
        return result > 0
    }

    fun obtenerUsuarioPorEmail(email: String): Usuario? {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM usuarios WHERE LOWER(TRIM(email)) = ?",
            arrayOf(email.trim().lowercase())
        )

        var usuario: Usuario? = null
        if (cursor.moveToFirst()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id_usuario"))
            val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
            val emailDb = cursor.getString(cursor.getColumnIndexOrThrow("email"))
            val pass = cursor.getString(cursor.getColumnIndexOrThrow("contrasena"))

            usuario = Usuario(id, nombre, emailDb, pass)
        }

        cursor.close()
        db.close()
        return usuario
    }

    @SuppressLint("UseKtx")
    fun eliminarUsuario(id: Int): Boolean {
        val db = dbHelper.writableDatabase
        db.beginTransaction()
        return try {
            // 1. Borrar cartas en listas del usuario
            db.delete("carta_lista", "id_lista IN (SELECT id_lista FROM lista WHERE id_usuario = ?)", arrayOf(id.toString()))

            // 2. Borrar listas del usuario
            db.delete("lista", "id_usuario = ?", arrayOf(id.toString()))

            // 3. Borrar el usuario
            val resultado = db.delete("usuarios", "id_usuario = ?", arrayOf(id.toString()))

            // 4. Borrar colecciones huérfanas
            db.execSQL("""
            DELETE FROM coleccion
            WHERE id_coleccion NOT IN (SELECT DISTINCT id_coleccion FROM lista)
        """.trimIndent())

            db.setTransactionSuccessful()
            resultado > 0
        } catch (e: Exception) {
            e.printStackTrace()
            false
        } finally {
            db.endTransaction()
            db.close()
        }
    }


    fun obtenerContrasena(idUsuario: Int): String? {
        val db = dbHelper.readableDatabase
        var contrasena: String? = null
        val cursor = db.rawQuery("SELECT contrasena FROM usuarios WHERE id_usuario = ?", arrayOf(idUsuario.toString()))
        if (cursor.moveToFirst()) {
            contrasena = cursor.getString(cursor.getColumnIndexOrThrow("contrasena"))
        }
        cursor.close()
        db.close()
        return contrasena
    }
    fun obtenerNombreUsuario(id: Int): String {
        val db =  dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT nombre FROM usuarios WHERE id_usuario = ?", arrayOf(id.toString()))
        var nombre = ""
        if (cursor.moveToFirst()) {
            nombre = cursor.getString(0)
        }
        cursor.close()
        db.close()
        return nombre
    }

    fun obtenerEmail(id: Int): String {
        val db =  dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT email FROM usuarios WHERE id_usuario = ?", arrayOf(id.toString()))
        var email = ""
        if (cursor.moveToFirst()) {
            email = cursor.getString(0)
        }
        cursor.close()
        db.close()
        return email
    }




}
