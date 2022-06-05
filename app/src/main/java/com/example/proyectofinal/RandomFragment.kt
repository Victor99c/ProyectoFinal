package com.example.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.proyectofinal.databinding.FragmentRandomBinding
import com.example.proyectofinal.remote.ProductoEntry
import com.example.proyectofinal.remote.RetrofitBuilder
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RandomFragment : Fragment(), ProductoCallback {

private lateinit var binding: FragmentRandomBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomBinding.inflate(layoutInflater)

        val num = arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)

        val li: Array<JSONObject> = arrayOf(
            JSONObject("{\"title\": \"\", \"price\":\"\",\"description\":\"\",\"image\":\"\"}"),
            JSONObject("{\"title\": \"\", \"price\":\"\",\"description\":\"\",\"image\":\"\"}"),
            JSONObject("{\"title\": \"\", \"price\":\"\",\"description\":\"\",\"image\":\"\"}"),
            JSONObject("{\"title\": \"\", \"price\":\"\",\"description\":\"\",\"image\":\"\"}"),
            JSONObject("{\"title\": \"\", \"price\":\"\",\"description\":\"\",\"image\":\"\"}")
            )

        for (i in 0..4){
            val ran = num.random()
            Log.d("res", ran.toString())
            val retroP = RetrofitBuilder.create().getProductById(ran.toString())
            retroP.enqueue(object : Callback<ProductoEntry> {
                override fun onResponse(call: Call<ProductoEntry>, response: Response<ProductoEntry>) {
                    Log.d("resp", response.body().toString())
                    val respuesta= response.body()
                    li.set(i,JSONObject("{\"id\": \"${respuesta?.id.toString()}\",\"title\": \"${respuesta?.nom.toString()}\", \"price\":\"${respuesta?.precio.toString()}\",\"description\":\"${respuesta?.descripcion.toString()}\",\"image\":\"${respuesta?.imagen.toString()}\"}"),)
                    val d = Log.d("res", li.toString())
                    val adapter = MainAdapter(li,this@RandomFragment)
                    binding.productos.adapter = adapter
                }
                override fun onFailure(call: Call<ProductoEntry>, t: Throwable) {
                    Log.d("respuesta", "error: ${t.message}")
                }

            })



        }

        return binding.root


    }

    override fun onClick(id: String) {
        val directio = RandomFragmentDirections.actionRandomFragmentToDetallesBusquedaFragment(id)
        findNavController().navigate(directio)
    }


}


