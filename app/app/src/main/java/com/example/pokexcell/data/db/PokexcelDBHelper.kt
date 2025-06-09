package com.example.pokexcell.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



class PokexcelDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("""
        CREATE TABLE usuarios (
            id_usuario INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre TEXT NOT NULL,
            email TEXT NOT NULL UNIQUE,
            contrasena TEXT NOT NULL
        );
    """.trimIndent())

        db?.execSQL("""
        CREATE TABLE coleccion (
            id_coleccion INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre_coleccion TEXT NOT NULL UNIQUE,
            imagen_url TEXT NOT NULL
        );
    """.trimIndent())

        db?.execSQL("""
        CREATE TABLE carta (
            id_carta INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre TEXT NOT NULL,
            coleccion TEXT NOT NULL,
            fecha_lanzamiento TEXT,
            numero_carta TEXT,
            rareza TEXT,
            url_imagen TEXT,
            id_coleccion INTEGER,
            dibujante TEXT,
            FOREIGN KEY(id_coleccion) REFERENCES coleccion(id_coleccion)
        );
    """.trimIndent())

        db?.execSQL("""
     CREATE TABLE lista (
    id_lista INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre_lista TEXT NOT NULL,
    id_usuario INTEGER NOT NULL,
    id_coleccion INTEGER NOT NULL,
    FOREIGN KEY(id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY(id_coleccion) REFERENCES coleccion(id_coleccion)
);

    """.trimIndent())

        db?.execSQL("""
        CREATE TABLE carta_lista (
            id_lista INTEGER NOT NULL,
            id_carta INTEGER NOT NULL,
            cantidad INTEGER NOT NULL DEFAULT 1,
            PRIMARY KEY (id_lista, id_carta),
            FOREIGN KEY(id_lista) REFERENCES lista(id_lista),
            FOREIGN KEY(id_carta) REFERENCES carta(id_carta)
        );
    """.trimIndent())

        // Insertar colecciones predefinidas
        db?.execSQL("INSERT INTO coleccion (id_coleccion, nombre_coleccion, imagen_url) VALUES (1, 'Pokémon Card 151 2023', 'https://flashstore.es/wp-content/uploads/2023/06/151.jpg')")
        db?.execSQL("INSERT INTO coleccion (id_coleccion, nombre_coleccion, imagen_url) VALUES (2, 'Pokémon VStar Universe 2023', 'https://flashstore.es/wp-content/uploads/2024/08/universesinplastico.jpg')")

        // Insertar cartas de la colección 151
        CartasDB151.insertarCartas151().forEachIndexed { index, sql ->
            try {
                db?.execSQL(sql)
                android.util.Log.d("DB_INSERT", "✅ Carta #${index + 1} insertada correctamente")
            } catch (e: Exception) {
                android.util.Log.e("DB_INSERT", "❌ Error al insertar carta #${index + 1}: ${e.message}")
            }
        }
        // Insertar cartas de la colección VSTAR
        CartasDBVSTAR.insertarCartasVStar().forEachIndexed { index, sql ->
            try {
                db?.execSQL(sql)
                android.util.Log.d("DB_INSERT", "✅ Carta #${index + 2} insertada correctamente")
            } catch (e: Exception) {
                android.util.Log.e("DB_INSERT", "❌ Error al insertar carta #${index + 2}: ${e.message}")
            }
        }


    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS carta_lista")
        db?.execSQL("DROP TABLE IF EXISTS lista")
        db?.execSQL("DROP TABLE IF EXISTS carta")
        db?.execSQL("DROP TABLE IF EXISTS coleccion")
        db?.execSQL("DROP TABLE IF EXISTS usuarios")
        onCreate(db)
    }

    companion object {
        const val DATABASE_NAME = "pokexcel.db"
        const val DATABASE_VERSION = 3
    }
}