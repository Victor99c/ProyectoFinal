package com.example.proyectofinal.remote

import com.google.gson.annotations.SerializedName

data class ProductoEntry(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val nom: String,
   @SerializedName("price")
    val precio: String,
    @SerializedName("category")
    val cate:String,
    @SerializedName("description")
    val descripcion: String,
    @SerializedName("image")
    val imagen: String,
    @SerializedName("rating")
    val calificaion: CaliEntry
)

data class CaliEntry(
    @SerializedName("rate")
    val cali: Float
)
