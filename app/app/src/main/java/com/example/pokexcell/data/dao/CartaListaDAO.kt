package com.example.pokexcell.data.dao

import android.content.Context
import com.example.pokexcell.data.db.PokexcelDBHelper
import com.example.pokexcell.data.model.Carta
import com.example.pokexcell.data.model.CartaConCantidad

class CartaListaDAO(context: Context) {

    private val dbHelper = PokexcelDBHelper(context)
    private val cartaDAO = CartaDAO(context)

    fun obtenerCartasPorLista(idLista: Int): List<CartaConCantidad> {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery(
            "SELECT id_carta, cantidad FROM carta_lista WHERE id_lista = ?",
            arrayOf(idLista.toString())
        )

        val cartasConCantidad = mutableListOf<CartaConCantidad>()
        if (cursor.moveToFirst()) {
            do {
                val idCarta = cursor.getInt(cursor.getColumnIndexOrThrow("id_carta"))
                val cantidad = cursor.getInt(cursor.getColumnIndexOrThrow("cantidad"))
                val carta = cartaDAO.obtenerCartaPorId(idCarta)
                if (carta != null) {
                    cartasConCantidad.add(CartaConCantidad(carta, cantidad))
                }
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return cartasConCantidad
    }

    fun obtenerCartasPorColeccion(idColeccion: Int): List<Carta> {
        val cartas = mutableListOf<Carta>()
        val db = dbHelper.readableDatabase

        val query = """
            SELECT id_carta, nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            FROM carta
            WHERE id_coleccion = ?
        """.trimIndent()

        val cursor = db.rawQuery(query, arrayOf(idColeccion.toString()))

        if (cursor.moveToFirst()) {
            do {
                val idCarta = cursor.getInt(cursor.getColumnIndexOrThrow("id_carta"))
                val nombreCarta = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                val coleccion = cursor.getString(cursor.getColumnIndexOrThrow("coleccion"))
                val fechaLanzamiento = cursor.getString(cursor.getColumnIndexOrThrow("fecha_lanzamiento"))
                val numeroCarta = cursor.getString(cursor.getColumnIndexOrThrow("numero_carta"))
                val rareza = cursor.getString(cursor.getColumnIndexOrThrow("rareza"))
                val urlImagen = cursor.getString(cursor.getColumnIndexOrThrow("url_imagen"))
                val idColeccionDB = cursor.getInt(cursor.getColumnIndexOrThrow("id_coleccion"))
                val dibujante = cursor.getString(cursor.getColumnIndexOrThrow("dibujante"))

                cartas.add(
                    Carta(
                        id_carta = idCarta,
                        nombre = nombreCarta,
                        coleccion = coleccion,
                        fecha_lanzamiento = fechaLanzamiento,
                        numero_carta = numeroCarta,
                        rareza = rareza,
                        url_imagen = urlImagen,
                        id_coleccion = idColeccionDB,
                        dibujante = dibujante
                    )
                )
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return cartas
    }

    fun obtenerIdsCartasDeUsuarioPorColeccion(idUsuario: Int, idColeccion: Int): List<Int> {
        val ids = mutableListOf<Int>()
        val db = dbHelper.readableDatabase

        val query = """
            SELECT DISTINCT cl.id_carta
            FROM carta_lista cl
            JOIN lista l ON cl.id_lista = l.id_lista
            WHERE l.id_usuario = ? AND l.id_coleccion = ?
        """.trimIndent()

        val cursor = db.rawQuery(query, arrayOf(idUsuario.toString(), idColeccion.toString()))
        if (cursor.moveToFirst()) {
            do {
                ids.add(cursor.getInt(cursor.getColumnIndexOrThrow("id_carta")))
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return ids
    }

    fun eliminarListaDeCartas(idLista: Int) {
        val db = dbHelper.writableDatabase

        // Eliminar las cartas asociadas a la lista
        db.delete("carta_lista", "id_lista = ?", arrayOf(idLista.toString()))

        // Eliminar la propia lista
        db.delete("lista", "id_lista = ?", arrayOf(idLista.toString()))

        db.close()
    }
}
