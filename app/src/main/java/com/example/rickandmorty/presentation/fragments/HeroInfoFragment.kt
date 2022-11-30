package com.example.rickandmorty.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentHeroInfoBinding

class HeroInfoFragment : Fragment() {

    private lateinit var binding: FragmentHeroInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}