package com.example.pcconfigurator.features.pcbuildsfeature.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pcconfigurator.databinding.ComponentItemBinding
import com.example.pcconfigurator.features.pcbuildsfeature.models.PluggableComponent

class BuildComponentAdapter :
    ListAdapter<PluggableComponent, BuildComponentViewHolder>(BuildComponentComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildComponentViewHolder {
        return BuildComponentViewHolder(
            binding = ComponentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BuildComponentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class BuildComponentViewHolder(
    private val binding: ComponentItemBinding
) : ViewHolder(binding.root) {
    fun bind(pluggableComponent: PluggableComponent) = with(binding) {
        componentNameTextView.text = pluggableComponent.name
        componentPriceTextView.text = pluggableComponent.price
    }
}

class BuildComponentComparator : DiffUtil.ItemCallback<PluggableComponent>() {
    override fun areItemsTheSame(
        oldItem: PluggableComponent,
        newItem: PluggableComponent
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: PluggableComponent,
        newItem: PluggableComponent
    ): Boolean {
        return oldItem == newItem
    }
}
