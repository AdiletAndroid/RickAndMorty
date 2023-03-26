package com.example.rickandmorty.main_page.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.common.mvp.BaseMvpFragment
import com.example.rickandmorty.databinding.FragmentHeroesListBinding
import com.example.rickandmorty.details_page.ui.DetailsPageFragment
import com.example.rickandmorty.main_page.model.Hero
import com.example.rickandmorty.main_page.ui.adapter.HeroesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val KEY = "key"

class HeroesListFragment :
    BaseMvpFragment<MainPageContract.View, MainPageContract.Presenter>(R.layout.fragment_heroes_list),
    MainPageContract.View {

    override val presenter: MainPagePresenter by viewModel()

    private val adapter: HeroesAdapter by lazy {
        HeroesAdapter { hero ->
            openDetailsPage(hero)
        }
    }
    private lateinit var binding: FragmentHeroesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager

        binding.recyclerView.adapter = adapter

        presenter.getHeroes()
    }

    override fun showHeroes(heroes: List<Hero>) {
        adapter.updateList(heroes)
    }

    private fun openDetailsPage(hero: Hero) {
        val bundle = Bundle()
        bundle.putParcelable(KEY, hero)
        val fragment = DetailsPageFragment()
        fragment.arguments = bundle
        loadFragment(fragment)

        Log.d("_____bundleTag", bundle.toString())
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}

