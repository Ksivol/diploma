package com.example.pcconfigurator.utils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.VideoCard
import com.example.pcconfigurator.databinding.VideoCardItemBinding

class VideoCardAdapter(
    private val onFavoriteClick: (VideoCard) -> Unit
) : ListAdapter<VideoCard, VideoCardAdapter.VideoCardHolder>(VideoCardComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoCardHolder {
        val binding = VideoCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoCardHolder(binding, onFavoriteClick)
    }

    override fun onBindViewHolder(holder: VideoCardHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class VideoCardHolder(
        private val binding: VideoCardItemBinding,
        private val onFavoriteClick: (VideoCard) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentItem: VideoCard? = null

        init {
            binding.favoriteBtn.setOnClickListener {
                currentItem?.let { onFavoriteClick(it) }
            }
        }

        fun bind(videoCard: VideoCard) = with(binding) {
            currentItem = videoCard
            vcNameTV.text = videoCard.name
            vcPriceTV.text = "${videoCard.price} ₽"
            vcMemoryTV.text = "Память: ${videoCard.videoMemory} ${videoCard.typeVideoMemory}"
            vcClockTV.text = "Частота: ${videoCard.clockRate} МГц"
            vcWattageTV.text = "TDP: ${videoCard.wattage} Вт"

            if (videoCard.favorite) {
                favoriteBtn.setColorFilter(Color.RED)
            } else {
                favoriteBtn.setColorFilter(Color.GRAY)
            }

            Glide.with(itemView.context)
                .load(videoCard.photo)
                .into(vcIV)
        }
    }

    class VideoCardComparator : DiffUtil.ItemCallback<VideoCard>() {
        override fun areItemsTheSame(oldItem: VideoCard, newItem: VideoCard): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: VideoCard, newItem: VideoCard): Boolean = oldItem == newItem
    }
}
