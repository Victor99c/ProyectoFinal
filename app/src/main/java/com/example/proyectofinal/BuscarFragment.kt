package com.example.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.proyectofinal.databinding.FragmentBuscarBinding
import com.example.proyectofinal.remote.ProductoEntry
import com.example.proyectofinal.remote.RetrofitBuilder
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BuscarFragment : Fragment() {
    private lateinit var binding: FragmentBuscarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBuscarBinding.inflate(layoutInflater)


        binding.busca.setOnClickListener {
            val idB = binding.busqueda.text.toString()
            val retroP = RetrofitBuilder.create().getProductById(idB.toString())
            retroP.enqueue(object : Callback<ProductoEntry> {

                override fun onResponse(call: Call<ProductoEntry>, response: Response<ProductoEntry>) {
                    val res = response.body()
                    val image = binding.imageView2
                    if (res != null){
                        binding.NomProduct.setText(res?.nom.toString())
                        binding.Precio.setText("$"+res?.precio.toString())
                        binding.Descripcion.setText(res?.descripcion.toString())
                        Picasso.get().load(res?.imagen.toString()).into(image)
                        Log.d("res",response.body().toString())
                    }}

                override fun onFailure(call: Call<ProductoEntry>, t: Throwable) {
                    Log.d("respuesta", "error: ${t.message}")
                }
            })
        }





        binding.detalle.setOnClickListener {
            val idD = binding.busqueda.text.toString()
            val dir = BuscarFragmentDirections.actionBuscarFragmentToDetallesBusquedaFragment(idD)
            findNavController().navigate(dir)
        }


        // Inflate the layout for this fragment
        return binding.root
    }


}