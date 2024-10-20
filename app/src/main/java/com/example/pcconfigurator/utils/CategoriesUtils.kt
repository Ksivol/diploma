package com.example.pcconfigurator.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pcconfigurator.databinding.CategoryItemBinding
import com.example.pcconfigurator.models.Category

class CategoriesAdapter : ListAdapter<Category, CategoryHolder>(CategoryComparator()){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CategoryHolder {
        return CategoryHolder(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(
        holder: CategoryHolder,
        position: Int,
    ) {
        holder.onBind(getItem(position))
    }

}

class CategoryHolder(private val binding: CategoryItemBinding) : ViewHolder(binding.root){
    fun onBind(category: Category) =
        with(binding) {
            //categoryItemIV. = картинка
            categoryItemTV.text = category.title
        }

}

class CategoryComparator : DiffUtil.ItemCallback<Category>(){
    override fun areItemsTheSame(
        oldItem: Category,
        newItem: Category,
    ): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(
        oldItem: Category,
        newItem: Category,
    ): Boolean = oldItem == newItem


}
