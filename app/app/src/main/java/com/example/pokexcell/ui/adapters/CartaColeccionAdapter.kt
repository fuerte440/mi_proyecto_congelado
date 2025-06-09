package com.example.pokexcell.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokexcell.R
import com.example.pokexcell.data.model.Carta

class CartaColeccionAdapter(
    private var cartas: List<Carta>,
    private var idsCartasUsuario: List<Int>


) : RecyclerView.Adapter<CartaColeccionAdapter.CartaViewHolder>() {

    class CartaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagenCarta: ImageView = itemView.findViewById(R.id.imagen_carta)
        val overlayRojo: View = itemView.findViewById(R.id.overlay_rojo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_carta_coleccion, parent, false)
        return CartaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartaViewHolder, position: Int) {
        val carta = cartas[position]

        Glide.with(holder.itemView.context)
            .load(carta.url_imagen) // o carta.imagen si es un recurso local
            .into(holder.imagenCarta)

        holder.overlayRojo.visibility = if (idsCartasUsuario.contains(carta.id_carta)) View.GONE else View.VISIBLE
    }
    fun actualizarDatos(nuevasCartas: List<Carta>, nuevasIds: List<Int>) {
        cartas = nuevasCartas
        idsCartasUsuario = nuevasIds
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = cartas.size
}
