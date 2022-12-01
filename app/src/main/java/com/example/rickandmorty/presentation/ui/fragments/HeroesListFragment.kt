package com.example.rickandmorty.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.databinding.FragmentHeroesListBinding
import com.example.rickandmorty.presentation.adapter.RAMAdapter

class HeroesListFragment : Fragment() {

    private lateinit var adapter: RAMAdapter
    private lateinit var binding: FragmentHeroesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroesListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}