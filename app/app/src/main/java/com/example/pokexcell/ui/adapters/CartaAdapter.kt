package com.example.pokexcell.ui.adapters // Asegúrate de que esta ruta coincida con la ubicación del archivo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.pokexcell.R
import com.example.pokexcell.data.model.CartaConCantidad

class CartaAdapter(
    private val cartas: MutableList<CartaConCantidad>,
    private val onCantidadCambiada: (CartaConCantidad, Int) -> Unit
) : RecyclerView.Adapter<CartaAdapter.CartaViewHolder>() {

    class CartaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagenImageView: ImageView = view.findViewById(R.id.imagen_carta)
        val nombreTextView: TextView = view.findViewById(R.id.nombre_carta)
        val rarezaTextView: TextView = view.findViewById(R.id.rareza_carta)
        val cantidadTextView: TextView = view.findViewById(R.id.cantidad_carta)
        val btnMas: Button = view.findViewById(R.id.btn_mas)
        val btnMenos: Button = view.findViewById(R.id.btn_menos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carta, parent, false)
        return CartaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartaViewHolder, position: Int) {
        val cartaConCantidad = cartas[position]
        val carta = cartaConCantidad.carta

        holder.nombreTextView.text = carta.nombre
        holder.rarezaTextView.text = carta.rareza

        val context = holder.itemView.context
        holder.cantidadTextView.text = context.getString(R.string.cantidad_carta, cartaConCantidad.cantidad)

        val glideUrl = GlideUrl(
            carta.url_imagen,
            LazyHeaders.Builder()
                .addHeader("User-Agent", "Mozilla/5.0")
                .build()
        )

        Glide.with(context)
            .load(glideUrl)
            .placeholder(R.drawable.placeholder2)
            .error(R.drawable.placeholder2)
            .into(holder.imagenImageView)

        holder.btnMas.setOnClickListener {
            val nuevaCantidad = cartaConCantidad.cantidad + 1
            onCantidadCambiada(cartaConCantidad, nuevaCantidad)
        }

        holder.btnMenos.setOnClickListener {
            if (cartaConCantidad.cantidad > 1) {
                val nuevaCantidad = cartaConCantidad.cantidad - 1
                onCantidadCambiada(cartaConCantidad, nuevaCantidad)
            } else {
                // Si la cantidad es 1 y se pulsa "-", se elimina
                onCantidadCambiada(cartaConCantidad, 0)
            }
        }

    }

    override fun getItemCount(): Int = cartas.size



}
