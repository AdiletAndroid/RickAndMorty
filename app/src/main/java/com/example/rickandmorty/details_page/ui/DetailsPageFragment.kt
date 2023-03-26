package com.example.rickandmorty.details_page.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.rickandmorty.R
import com.example.rickandmorty.common.mvp.BaseFragment
import com.example.rickandmorty.databinding.FragmentHeroInfoBinding
import com.example.rickandmorty.main_page.model.Hero

private const val KEY = "key"

class DetailsPageFragment : BaseFragment(R.layout.fragment_hero_info), DetailsPageContract.View {

    private lateinit var binding: FragmentHeroInfoBinding
    private val heroInfo: Hero? by lazy {
        arguments?.getParcelable(KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showHeroInfo()
        Log.d("__________HERO_INFO", heroInfo.toString())
    }

    override fun showHeroInfo() {
        with(binding) {
            imageViewPicture.load(heroInfo?.image)
            textViewName.text = heroInfo?.name
            textViewGender.text = heroInfo?.gender
            textViewStatus.text = heroInfo?.status
            textViewSpecies.text = heroInfo?.species
        }
    }
}