package com.example.pcconfigurator.utils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.HardDrive
import com.example.pcconfigurator.databinding.HardDriveItemBinding

class HardDriveAdapter(
    private val onFavoriteClick: (HardDrive) -> Unit
) : ListAdapter<HardDrive, HardDriveAdapter.HardDriveHolder>(HardDriveComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HardDriveHolder {
        val binding = HardDriveItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HardDriveHolder(binding, onFavoriteClick)
    }

    override fun onBindViewHolder(holder: HardDriveHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HardDriveHolder(
        private val binding: HardDriveItemBinding,
        private val onFavoriteClick: (HardDrive) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentItem: HardDrive? = null

        init {
            binding.favoriteBtn.setOnClickListener {
                currentItem?.let { onFavoriteClick(it) }
            }
        }

        fun bind(hardDrive: HardDrive) = with(binding) {
            currentItem = hardDrive
            hdNameTV.text = hardDrive.name
            hdPriceTV.text = "${hardDrive.price} ₽"
            hdTypeTV.text = "Тип: ${hardDrive.type}"
            hdCapacityTV.text = "Объем: ${hardDrive.capacity}"

            if (hardDrive.favorite) {
                favoriteBtn.setColorFilter(Color.RED)
            } else {
                favoriteBtn.setColorFilter(Color.GRAY)
            }

            Glide.with(itemView.context)
                .load(hardDrive.photo)
                .into(hdIV)
        }
    }

    class HardDriveComparator : DiffUtil.ItemCallback<HardDrive>() {
        override fun areItemsTheSame(oldItem: HardDrive, newItem: HardDrive): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: HardDrive, newItem: HardDrive): Boolean = oldItem == newItem
    }
}
