package com.example.pcconfigurator.utils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.CPU
import com.example.pcconfigurator.databinding.CpuItemBinding

class CpuAdapter(
    private val onFavoriteClick: (CPU) -> Unit
) : ListAdapter<CPU, CpuAdapter.CpuHolder>(CpuComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CpuHolder {
        val binding = CpuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CpuHolder(binding, onFavoriteClick)
    }

    override fun onBindViewHolder(holder: CpuHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CpuHolder(
        private val binding: CpuItemBinding,
        private val onFavoriteClick: (CPU) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentItem: CPU? = null

        init {
            binding.favoriteBtn.setOnClickListener {
                currentItem?.let { onFavoriteClick(it) }
            }
        }

        fun bind(cpu: CPU) = with(binding) {
            currentItem = cpu
            cpuNameTV.text = cpu.name
            cpuPriceTV.text = "${cpu.price} ₽"
            cpuSocketTV.text = "Сокет: ${cpu.socket}"
            cpuClockRateTV.text = "Частота: ${cpu.clockRate}"
            cpuWattageTV.text = "TDP: ${cpu.wattage} Вт"

            if (cpu.favorite) {
                favoriteBtn.setColorFilter(Color.RED)
            } else {
                favoriteBtn.setColorFilter(Color.GRAY)
            }

            Glide.with(itemView.context)
                .load(cpu.photo)
                .into(cpuIV)
        }
    }

    class CpuComparator : DiffUtil.ItemCallback<CPU>() {
        override fun areItemsTheSame(oldItem: CPU, newItem: CPU): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: CPU, newItem: CPU): Boolean = oldItem == newItem
    }
}
