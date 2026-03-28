package com.example.pcconfigurator.features.favoritesfeature.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pcconfigurator.databinding.FavoritesItemBinding
import com.example.pcconfigurator.features.favoritesfeature.models.Favorites

class FavoritesAdapter : ListAdapter<Favorites, FavoritesHolder>(FavoritesComparator()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): FavoritesHolder {
        return FavoritesHolder(
            FavoritesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(
        holder: FavoritesHolder,
        position: Int,
    ): Unit {
        holder.onBind(getItem(position))
    }
}


class FavoritesHolder(private val binding: FavoritesItemBinding) : ViewHolder(binding.root) {
    fun onBind(
        favorites: Favorites
    ): Unit {
        with(binding) {
            //favoritesItemIV. = картинка
            favoritesItemTV.text = favorites.title
        }
    }
}

class FavoritesComparator : DiffUtil.ItemCallback<Favorites>() {
    override fun areItemsTheSame(
        oldItem: Favorites,
        newItem: Favorites,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Favorites,
        newItem: Favorites,
    ): Boolean {
        return oldItem == newItem
    }
}