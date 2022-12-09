package com.example.rickandmorty.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentHeroesListBinding
import com.example.rickandmorty.domain.model.HeroModel
import com.example.rickandmorty.presentation.adapter.EndlessScrollListener
import com.example.rickandmorty.presentation.adapter.HeroesAdapter
import com.example.rickandmorty.presentation.presenters.HeroesListPresenter
import com.example.rickandmorty.presentation.presenters.HeroesView
import org.koin.android.ext.android.inject

class HeroesListFragment : Fragment(), HeroesView {

    private val presenter: HeroesListPresenter by inject()
    private lateinit var adapter: HeroesAdapter
    private lateinit var binding: FragmentHeroesListBinding
    //private val adapter by lazy { HeroesAdapter(this::onItemClick) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = HeroesAdapter(onItemClick = {
            presenter.loadHeroes()
            onItemClick()
           //onScrollListener()
        })
        binding.recyclerView.adapter = adapter

        presenter.loadHeroes()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun showHeroes(heroes: List<HeroModel>) {
        adapter.setContent(heroes)
    }

    private fun onItemClick() {
        binding.recyclerView.setOnClickListener {
            val id = it.id
            val bundle = Bundle()
            bundle.putSerializable("key", id)
            findNavController().navigate(R.id.action_heroesListFragment_to_heroInfoFragment, bundle)
        }
    }

//    private fun onScrollListener() {
//        val scrollListener = EndlessScrollListener(LinearLayoutManager(requireContext())) { page ->
//            presenter.loadHeroes()
//        }
//        return binding.recyclerView.addOnScrollListener(scrollListener)
//    }
}

