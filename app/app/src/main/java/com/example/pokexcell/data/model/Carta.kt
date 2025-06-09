package com.example.pokexcell.data.model

import android.os.Parcel
import android.os.Parcelable

data class Carta(
    val id_carta: Int = 0,
    val nombre: String ="",
    val coleccion: String ="",
    val fecha_lanzamiento: String ="",
    val numero_carta: String ="",
    val rareza: String ="",
    val url_imagen: String ="",
    val id_coleccion: Int =0,
    val dibujante: String =""
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id_carta)
        parcel.writeString(nombre)
        parcel.writeString(coleccion)
        parcel.writeString(fecha_lanzamiento)
        parcel.writeString(numero_carta)
        parcel.writeString(rareza)
        parcel.writeString(url_imagen)
        parcel.writeInt(id_coleccion)
        parcel.writeString(dibujante)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Carta> {
        override fun createFromParcel(parcel: Parcel): Carta {
            return Carta(parcel)
        }

        override fun newArray(size: Int): Array<Carta?> {
            return arrayOfNulls(size)
        }
    }
}
