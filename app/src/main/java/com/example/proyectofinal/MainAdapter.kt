package com.example.proyectofinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject
import com.example.proyectofinal.ProductoCallback
import com.example.proyectofinal.databinding.ItemProductoBinding
import com.example.proyectofinal.remote.ProductoEntry
import com.squareup.picasso.Picasso
import retrofit2.Callback


class MainAdapter(private val li: Array<JSONObject>, private val callBack: ProductoCallback): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = ItemProductoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding,callBack)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int){

        holder.render(li[position])

    }

    override fun getItemCount(): Int = li.size
    class MainHolder(val binding: ItemProductoBinding, val callBack: ProductoCallback): RecyclerView.ViewHolder(binding.root){
        fun render(resp: JSONObject){
            binding.NoProduct.setText(resp.getString("title"))
            binding.Descripcio.setText(resp.getString("description"))
            binding.Preci.setText(resp.getString("price"))
            val imagen = binding.imageV
            val link = resp.getString("image").toString()
            if (link != null && !link.isEmpty()) {
                Picasso.get().load(link).into(imagen)
            }
              binding.detalle.setOnClickListener {
             callBack.onClick(resp.getString("id"))
          }
        }
    }
}