package com.example.pcconfigurator.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pcconfigurator.databinding.CategoryItemBinding
import com.example.pcconfigurator.features.categoriesfeature.models.Category

class CategoriesAdapter(
    private val onItemClick: (Category) -> Unit
) : ListAdapter<Category, CategoryHolder>(CategoryComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder =
        CategoryHolder(
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClick
        )

    override fun onBindViewHolder(holder: CategoryHolder, position: Int): Unit =
        holder.onBind(getItem(position))
}

class CategoryHolder(
    private val binding: CategoryItemBinding,
    private val onItemClick: (Category) -> Unit
) : ViewHolder(binding.root) {
    fun onBind(category: Category) = with(binding) {
        categoryItemIV.setImageResource(category.image)
        categoryItemTV.text = category.title
        root.setOnClickListener { onItemClick(category) }
    }
}

class CategoryComparator : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean = oldItem == newItem
}
