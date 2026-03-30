package com.example.pcconfigurator.utils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.PSU
import com.example.pcconfigurator.databinding.PsuItemBinding

class PsuAdapter(
    private val onFavoriteClick: (PSU) -> Unit
) : ListAdapter<PSU, PsuAdapter.PsuHolder>(PsuComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PsuHolder {
        val binding = PsuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PsuHolder(binding, onFavoriteClick)
    }

    override fun onBindViewHolder(holder: PsuHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PsuHolder(
        private val binding: PsuItemBinding,
        private val onFavoriteClick: (PSU) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentItem: PSU? = null

        init {
            binding.favoriteBtn.setOnClickListener {
                currentItem?.let { onFavoriteClick(it) }
            }
        }

        fun bind(psu: PSU) = with(binding) {
            currentItem = psu
            psuNameTV.text = psu.name
            psuPriceTV.text = "${psu.price} ₽"
            psuWattageTV.text = "Мощность: ${psu.wattage}"
            psuPinsTV.text = "CPU: ${psu.pinCPU}, GPU: ${psu.pinPCIE}"

            if (psu.favorite) {
                favoriteBtn.setColorFilter(Color.RED)
            } else {
                favoriteBtn.setColorFilter(Color.GRAY)
            }

            Glide.with(itemView.context)
                .load(psu.photo)
                .into(psuIV)
        }
    }

    class PsuComparator : DiffUtil.ItemCallback<PSU>() {
        override fun areItemsTheSame(oldItem: PSU, newItem: PSU): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: PSU, newItem: PSU): Boolean = oldItem == newItem
    }
}
