package com.example.rickandmorty.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmorty.databinding.ItemHeroBinding
import com.example.rickandmorty.domain.model.HeroModel

class RAMAdapter(
    private val onItemClick: (HeroModel) -> Unit
) : RecyclerView.Adapter<RAMAdapter.ViewHolder>() {

    private val model = mutableListOf<HeroModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(model[position])
    }

    override fun getItemCount(): Int {
        return model.size
    }

    inner class ViewHolder(val binding: ItemHeroBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: HeroModel) {
            with(binding) {
                imageViewPicture.load(model.image)
                textViewName.text = model.name
                textViewGender.text = model.gender

                itemView.setOnClickListener {
                    onItemClick.invoke(model)
                }
            }
        }
    }
}