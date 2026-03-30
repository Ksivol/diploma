package com.example.pcconfigurator.utils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.Cooler
import com.example.pcconfigurator.databinding.CoolerItemBinding

class CoolerAdapter(
    private val onFavoriteClick: (Cooler) -> Unit
) : ListAdapter<Cooler, CoolerAdapter.CoolerHolder>(CoolerComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoolerHolder {
        val binding = CoolerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // Передаем лямбду в конструктор Холдера
        return CoolerHolder(binding, onFavoriteClick)
    }

    override fun onBindViewHolder(holder: CoolerHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CoolerHolder(
        private val binding: CoolerItemBinding,
        private val onFavoriteClick: (Cooler) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        // Объект, который мы сейчас отображаем
        private var currentCooler: Cooler? = null

        init {
            // Устанавливаем клик ОДИН РАЗ при создании объекта
            binding.favoriteBtn.setOnClickListener {
                // Используем сохраненную ссылку на данные
                currentCooler?.let { cooler ->
                    onFavoriteClick(cooler)
                }
            }

            // Если нужен клик по всей карточке:
            binding.root.setOnClickListener {
                currentCooler?.let { /* onItemClick(it) */ }
            }
        }

        fun bind(cooler: Cooler) = with(binding) {
            currentCooler = cooler
            coolerNameTV.text = cooler.name
            coolerPriceTV.text = "${cooler.price} ₽"
            coolerSocketTV.text = "Сокет: ${cooler.socket}"
            coolerHeatSinkTV.text = "TDP: ${cooler.heatSink} Вт"
            coolerSizeTV.text = "Размер: ${cooler.size} мм"

            if (cooler.favorite) {
                favoriteBtn.setColorFilter(Color.RED)
            } else {
                favoriteBtn.setColorFilter(Color.GRAY)
            }

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
