package com.example.rickandmorty.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.rickandmorty.databinding.FragmentHeroInfoBinding
import com.example.rickandmorty.domain.model.HeroModel
import com.example.rickandmorty.presentation.presenters.HeroInfoPresenter
import com.example.rickandmorty.presentation.presenters.HeroInfoView
import org.koin.android.ext.android.inject

class HeroInfoFragment : Fragment(), HeroInfoView {

    private val presenter: HeroInfoPresenter by inject()
    private lateinit var binding: FragmentHeroInfoBinding

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
        presenter.attachView(this)
    }

    override fun showHeroInfo() {
        val heroInfo = arguments?.getSerializable("key") as HeroModel
        binding.imageViewPicture.load(heroInfo.image)
        binding.textViewName.text = heroInfo.name
        binding.textViewGender.text = heroInfo.gender
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}