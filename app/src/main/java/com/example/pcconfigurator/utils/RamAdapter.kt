package com.example.pcconfigurator.utils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.RAM
import com.example.pcconfigurator.databinding.RamItemBinding

class RamAdapter(
    private val onFavoriteClick: (RAM) -> Unit
) : ListAdapter<RAM, RamAdapter.RamHolder>(RamComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RamHolder {
        val binding = RamItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RamHolder(binding, onFavoriteClick)
    }

    override fun onBindViewHolder(holder: RamHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RamHolder(
        private val binding: RamItemBinding,
        private val onFavoriteClick: (RAM) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentItem: RAM? = null

        init {
            binding.favoriteBtn.setOnClickListener {
                currentItem?.let { onFavoriteClick(it) }
            }
        }

        fun bind(ram: RAM) = with(binding) {
            currentItem = ram
            ramNameTV.text = ram.name
            ramPriceTV.text = "${ram.price} ₽"
            ramTypeTV.text = "Тип: ${ram.type}"
            ramClockTV.text = "Частота: ${ram.clockRate} МГц"
            ramQuantityTV.text = "Конфигурация: ${ram.quantity}"

            if (ram.favorite) {
                favoriteBtn.setColorFilter(Color.RED)
            } else {
                favoriteBtn.setColorFilter(Color.GRAY)
            }

            Glide.with(itemView.context)
                .load(ram.photo)
                .into(ramIV)
        }
    }

    class RamComparator : DiffUtil.ItemCallback<RAM>() {
        override fun areItemsTheSame(oldItem: RAM, newItem: RAM): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: RAM, newItem: RAM): Boolean = oldItem == newItem
    }
}
