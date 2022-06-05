package com.example.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectofinal.databinding.FragmentBuscarBinding
import com.example.proyectofinal.databinding.FragmentDetallesBusquedaBinding
import com.example.proyectofinal.remote.CaliEntry
import com.example.proyectofinal.remote.ProductoEntry
import com.example.proyectofinal.remote.RetrofitBuilder
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetallesBusquedaFragment : Fragment() {

private lateinit var binding: FragmentDetallesBusquedaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetallesBusquedaBinding.inflate(layoutInflater)
            val idB = arguments?.getString("id")
            val retroP = RetrofitBuilder.create().getProductById(idB.toString())
            retroP.enqueue(object : retrofit2.Callback<ProductoEntry> {

                override fun onResponse(call: Call<ProductoEntry>, response: Response<ProductoEntry>) {
                 val res = response.body()
                    if (res != null){
                    Log.d("res",response.body().toString())
                        binding.nombr.setText(response.body()?.nom.toString())
                        binding.desc.setText(response.body()?.descripcion.toString())
                        binding.pr.setText("$"+response.body()?.precio.toString())
                        binding.cat.setText("Cateroy "+response.body()?.cate.toString())
                        binding.rate.setText("Calficacion "+response.body()?.calificaion?.cali.toString())
                        val im = binding.product
                        Picasso.get().load(response.body()?.imagen.toString()).into(im)
                }}

                override fun onFailure(call: Call<ProductoEntry>, t: Throwable) {
                    Log.d("respuesta", "error: ${t.message}")
                }
            })
        return binding.root
    }


}