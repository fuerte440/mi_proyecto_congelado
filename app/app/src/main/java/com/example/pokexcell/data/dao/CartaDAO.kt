package com.example.pokexcell.data.dao

import android.content.Context
import android.database.Cursor
import com.example.pokexcell.data.db.PokexcelDBHelper
import com.example.pokexcell.data.model.Carta

class CartaDAO(context: Context) {

    private val dbHelper = PokexcelDBHelper(context)

    fun obtenerCartaPorNumero(numeroCarta: String, idColeccion: Int): Carta? {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM carta WHERE numero_carta LIKE ? AND id_coleccion = ?",
            arrayOf("$numeroCarta%", idColeccion.toString())
        )

        val carta = if (cursor.moveToFirst()) {
            cursorToCarta(cursor)
        } else {
            null
        }

        cursor.close()
        db.close()
        return carta
    }

    fun obtenerCartaPorId(idCarta: Int): Carta? {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM carta WHERE id_carta = ?",
            arrayOf(idCarta.toString())
        )

        val carta = if (cursor.moveToFirst()) {
            cursorToCarta(cursor)
        } else {
            null
        }

        cursor.close()
        db.close()
        return carta
    }

    private fun cursorToCarta(cursor: Cursor): Carta {
        return Carta(
            id_carta = cursor.getInt(cursor.getColumnIndexOrThrow("id_carta")),
            nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
            coleccion = cursor.getString(cursor.getColumnIndexOrThrow("coleccion")),
            fecha_lanzamiento = cursor.getString(cursor.getColumnIndexOrThrow("fecha_lanzamiento")),
            numero_carta = cursor.getString(cursor.getColumnIndexOrThrow("numero_carta")),
            rareza = cursor.getString(cursor.getColumnIndexOrThrow("rareza")),
            url_imagen = cursor.getString(cursor.getColumnIndexOrThrow("url_imagen")),
            id_coleccion = cursor.getInt(cursor.getColumnIndexOrThrow("id_coleccion")),
            dibujante = cursor.getString(cursor.getColumnIndexOrThrow("dibujante"))
        )
    }
}
