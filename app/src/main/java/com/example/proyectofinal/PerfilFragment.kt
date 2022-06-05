package com.example.proyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.example.proyectofinal.databinding.FragmentPerfilBinding

class PerfilFragment : Fragment() {
private lateinit var binding: FragmentPerfilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPerfilBinding.inflate(layoutInflater)


        val usu = "1"
        val db = Firebase.database
        val dRef = db.reference

        dRef.child("Usuario").child(usu).child("nombre").get().addOnSuccessListener { response ->
            binding.nomFireB.setText(response.value.toString())}
        dRef.child("Usuario").child(usu).child("nombreU").get().addOnSuccessListener { response ->
            binding.nomUfireB.setText(response.value.toString())}
        dRef.child("Usuario").child(usu).child("niv").get().addOnSuccessListener { response ->
            binding.nivFireBf.setText(response.value.toString())}
        dRef.child("Usuario").child(usu).child("puntosF").get().addOnSuccessListener { response ->
            binding.puntosFirebF.setText(response.value.toString())}
        dRef.child("Usuario").child(usu).child("puntos").get().addOnSuccessListener { response ->
            binding.puntosFirebA.setText(response.value.toString())}

        return binding.root
    }
}