package com.example.pokexcell.data.dao

import android.content.Context
import com.example.pokexcell.data.db.PokexcelDBHelper
import com.example.pokexcell.data.model.Lista

class ListaDAO(context: Context) {

    private val dbHelper = PokexcelDBHelper(context)

    fun obtenerColeccionesDeUsuario(idUsuario: Int): List<Lista> {
        val listas = mutableListOf<Lista>()
        val db = dbHelper.readableDatabase

        val query = """
        SELECT id_lista, nombre_lista, id_coleccion
        FROM lista
        WHERE id_usuario = ?
    """.trimIndent()

        val cursor = db.rawQuery(query, arrayOf(idUsuario.toString()))

        if (cursor.moveToFirst()) {
            do {
                val idLista = cursor.getInt(cursor.getColumnIndexOrThrow("id_lista"))
                val nombreLista = cursor.getString(cursor.getColumnIndexOrThrow("nombre_lista"))
                val idColeccion = cursor.getInt(cursor.getColumnIndexOrThrow("id_coleccion"))
                listas.add(Lista(idLista, nombreLista, idUsuario, idColeccion))
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return listas
    }


}
