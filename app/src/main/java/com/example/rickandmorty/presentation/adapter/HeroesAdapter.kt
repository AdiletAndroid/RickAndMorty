package com.example.rickandmorty.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmorty.databinding.ItemHeroBinding
import com.example.rickandmorty.domain.model.HeroModel

class HeroesAdapter(
    private val onItemClick: OnItemClick
) : RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {

    private val data = mutableListOf<HeroModel>()

    fun setContent(heroes: List<HeroModel>) {
        data.clear()
        data.addAll(heroes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
        holder.itemView.setOnClickListener {
            onItemClick.clickListener(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(private val binding: ItemHeroBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(hero: HeroModel) {
            with(binding) {
                imageViewPicture.load(hero.image)
                textViewName.text = hero.name
                textViewGender.text = hero.gender
            }
        }
    }

    interface OnItemClick {
        fun clickListener(hero: HeroModel)
    }
}