package com.example.pcconfigurator.features.pcbuildsfeature.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pcconfigurator.databinding.ComponentItemBinding
import com.example.pcconfigurator.features.pcbuildsfeature.models.PluggableComponent

class BuildComponentAdapter :
    ListAdapter<PluggableComponent, BuildComponentAdapter.BuildComponentViewHolder>(BuildComponentComparator()) {
    private lateinit var binding: ComponentItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildComponentViewHolder {
        binding = ComponentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuildComponentViewHolder()
    }

    override fun onBindViewHolder(holder: BuildComponentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BuildComponentViewHolder : ViewHolder(binding.root) {
        fun bind(pluggableComponent: PluggableComponent) = with(binding) {
            componentNameTextView.text = pluggableComponent.name
            componentPriceTextView.text = pluggableComponent.price
        }
    }
}

class BuildComponentComparator : DiffUtil.ItemCallback<PluggableComponent>() {
    override fun areItemsTheSame(oldItem: PluggableComponent, newItem: PluggableComponent): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PluggableComponent, newItem: PluggableComponent): Boolean = oldItem == newItem
}
