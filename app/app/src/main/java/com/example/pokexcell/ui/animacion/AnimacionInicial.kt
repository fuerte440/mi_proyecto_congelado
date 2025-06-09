package com.example.pokexcell.ui.animacion

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.pokexcell.R
import com.example.pokexcell.ui.iniciosesion.ActividadInicioSesion

class AnimacionInicial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_animacion)

        println("🔍 AnimacionInicial cargada correctamente")

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ActividadInicioSesion::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }

}
