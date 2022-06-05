package com.example.proyectofinal.remote

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitBuilder {

    @GET("products/{id}")
    fun getProductById(@Path("id") id: String): Call<ProductoEntry>

    companion object{
        private val URL_API = "https://fakestoreapi.com/"
        fun create(): RetrofitBuilder{
            val retroProduc = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL_API)
                .build()

            return retroProduc.create(RetrofitBuilder::class.java)
        }
    }
}