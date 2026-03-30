package com.example.pcconfigurator.utils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.PcCase
import com.example.pcconfigurator.databinding.PcCaseItemBinding

class PcCaseAdapter(
    private val onFavoriteClick: (PcCase) -> Unit
) : ListAdapter<PcCase, PcCaseAdapter.PcCaseHolder>(PcCaseComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PcCaseHolder {
        val binding = PcCaseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PcCaseHolder(binding, onFavoriteClick)
    }

    override fun onBindViewHolder(holder: PcCaseHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PcCaseHolder(
        private val binding: PcCaseItemBinding,
        private val onFavoriteClick: (PcCase) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentItem: PcCase? = null

        init {
            binding.favoriteBtn.setOnClickListener {
                currentItem?.let { onFavoriteClick(it) }
            }
        }

        fun bind(pcCase: PcCase) = with(binding) {
            currentItem = pcCase
            caseNameTV.text = pcCase.name
            casePriceTV.text = "${pcCase.price} ₽"
            caseSizeTV.text = "Размер: ${pcCase.size}"

            if (pcCase.favorite) {
                favoriteBtn.setColorFilter(Color.RED)
            } else {
                favoriteBtn.setColorFilter(Color.GRAY)
            }

            Glide.with(itemView.context)
                .load(pcCase.photo)
                .into(caseIV)
        }
    }

    class PcCaseComparator : DiffUtil.ItemCallback<PcCase>() {
        override fun areItemsTheSame(oldItem: PcCase, newItem: PcCase): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: PcCase, newItem: PcCase): Boolean = oldItem == newItem
    }
}
