package com.example.pokexcell.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokexcell.R
import com.example.pokexcell.data.model.Lista

class ListaAdapter(
    private var listasDelUsuario: List<Lista>,
    private val onItemClick: (Lista) -> Unit,
    private val onExportClick: (Lista) -> Unit,
    private val onSendEmailClick: (Lista) -> Unit
) : RecyclerView.Adapter<ListaAdapter.ListaViewHolder>() {

    class ListaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreLista: TextView = itemView.findViewById(R.id.texto_nombre_lista)
        val idLista: TextView = itemView.findViewById(R.id.texto_id_lista)
        val botonExportar: View = itemView.findViewById(R.id.boton_exportar_lista)
        val botonEnviar: View = itemView.findViewById(R.id.boton_enviar_lista)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista, parent, false)
        return ListaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        val lista = listasDelUsuario[position]
        holder.nombreLista.text = lista.nombre_lista
        val context = holder.itemView.context
        holder.idLista.text = context.getString(R.string.id_lista_formato, lista.id_lista)
        holder.itemView.setOnClickListener {
            onItemClick(lista)
        }
        holder.botonExportar.setOnClickListener {
            onExportClick(lista)
        }
        holder.botonEnviar.setOnClickListener {
            onSendEmailClick(lista)
        }
    }

    override fun getItemCount(): Int = listasDelUsuario.size

    // Método para actualizar la lista y refrescar el RecyclerView
    @SuppressLint("NotifyDataSetChanged")
    fun actualizarListas(nuevasListas: List<Lista>) {
        listasDelUsuario = nuevasListas
        notifyDataSetChanged()
    }
}
