package com.example.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var  navCon: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        val database = Firebase.database
        val myRef = database.reference

        myRef.child("Usuario").child("3").setValue(Usuarios(3,"Rosario","Rosari123", "Nivel 1", 100,100))
        myRef.child("Usuario").child("2").setValue(Usuarios(2,"Victor","Vic123", "Nivel 3", 590,10))
        myRef.child("Usuario").child("1").setValue(Usuarios(1,"Gloria","Glory123", "Nivel 2", 250,150))

*/
        val bottomNavV: BottomNavigationView =findViewById(R.id.NavBottom)
        val navHostFra =supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navCon = navHostFra.navController
        bottomNavV.setupWithNavController(navCon)
    }



    }
