package com.example.rickandmorty.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.ActivityMainBinding

class RootActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        navController = findNavController(R.id.nav_host_fragment_activity_main)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp()
//    }
}
