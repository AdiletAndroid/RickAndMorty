package com.example.rickandmorty.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmorty.databinding.ItemHeroBinding
import com.example.rickandmorty.main_page.model.Hero
import com.example.rickandmorty.main_page.ui.diffUtil.MyDiffUtilCallback

class HeroesAdapter(
    private val onItemClick: (hero: Hero) -> Unit
) : RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {

    private var data = mutableListOf<Hero>()

//    fun setContent(heroes: List<Hero>) {
//        data.clear()
//        data.addAll(heroes)
//        notifyDataSetChanged()
//        //diffUtils
//    }

    fun updateList(heroes: List<Hero>) {
        val diffCallback = MyDiffUtilCallback(data, heroes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        data = heroes as MutableList<Hero>
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(
        private val binding: ItemHeroBinding,
        private val onItemClick: (hero: Hero) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(hero: Hero) {
            with(binding) {
                imageViewPicture.load(hero.image)
                textViewName.text = hero.name
                textViewGender.text = hero.gender
            }
            itemView.setOnClickListener {
                onItemClick.invoke(hero)
            }
        }
    }

    interface OnItemClick {
        fun openDetailsPage(hero: Hero)
    }
}