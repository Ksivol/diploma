package com.example.pcconfigurator.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.Cooler
import com.example.pcconfigurator.databinding.CoolerItemBinding

class CoolerAdapter : ListAdapter<Cooler, CoolerAdapter.CoolerHolder>(CoolerComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoolerHolder {
        return CoolerHolder(
            CoolerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CoolerHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CoolerHolder(private val binding: CoolerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cooler: Cooler) = with(binding) {
            coolerNameTV.text = cooler.name
            coolerPriceTV.text = "Цена: ${cooler.price} ₽"
            coolerSocketTV.text = "Сокет: ${cooler.socket}"
            coolerHeatSinkTV.text = "TDP: ${cooler.heatSink} Вт"

            Glide.with(itemView.context)
                .load(cooler.photo)
                .into(coolerIV)
        }
    }

    class CoolerComparator : DiffUtil.ItemCallback<Cooler>() {
        override fun areItemsTheSame(oldItem: Cooler, newItem: Cooler): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Cooler, newItem: Cooler): Boolean =
            oldItem == newItem
    }
}
