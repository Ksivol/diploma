package com.example.pcconfigurator.utils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.Motherboard
import com.example.pcconfigurator.databinding.MotherboardItemBinding

class MotherboardAdapter(
    private val onFavoriteClick: (Motherboard) -> Unit
) : ListAdapter<Motherboard, MotherboardAdapter.MotherboardHolder>(MotherboardComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotherboardHolder {
        val binding = MotherboardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MotherboardHolder(binding, onFavoriteClick)
    }

    override fun onBindViewHolder(holder: MotherboardHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MotherboardHolder(
        private val binding: MotherboardItemBinding,
        private val onFavoriteClick: (Motherboard) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentItem: Motherboard? = null

        init {
            binding.favoriteBtn.setOnClickListener {
                currentItem?.let { onFavoriteClick(it) }
            }
        }

        fun bind(motherboard: Motherboard) = with(binding) {
            currentItem = motherboard
            mbNameTV.text = motherboard.name
            mbPriceTV.text = "${motherboard.price} ₽"
            mbSocketTV.text = "Сокет: ${motherboard.socket}"
            mbSizeTV.text = "Размер: ${motherboard.size}"

            if (motherboard.favorite) {
                favoriteBtn.setColorFilter(Color.RED)
            } else {
                favoriteBtn.setColorFilter(Color.GRAY)
            }

            Glide.with(itemView.context)
                .load(motherboard.photo)
                .into(mbIV)
        }
    }

    class MotherboardComparator : DiffUtil.ItemCallback<Motherboard>() {
        override fun areItemsTheSame(oldItem: Motherboard, newItem: Motherboard): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Motherboard, newItem: Motherboard): Boolean = oldItem == newItem
    }
}
