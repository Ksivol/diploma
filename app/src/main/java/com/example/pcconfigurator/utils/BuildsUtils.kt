package com.example.pcconfigurator.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.pcconfigurator.databinding.BuildItemBinding
import com.example.pcconfigurator.models.Build

class BuildsAdapter : ListAdapter<Build, BuildHolder>(BuildComporator()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BuildHolder {
        return BuildHolder(
            BuildItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(
        holder: BuildHolder,
        position: Int,
    ) {
        holder.onBind(getItem(position))
    }
}

class BuildHolder(private val binding: BuildItemBinding) : ViewHolder(binding.root) {
    fun onBind(build: Build) =
        with(binding) {
            Glide
                .with(binding.root.context)
                .load(build.image)
                .centerCrop()
                .into(buildItemIV)
            buildItemTV.text = build.title
        }
}

class BuildComporator : DiffUtil.ItemCallback<Build>() {
    override fun areItemsTheSame(
        oldItem: Build,
        newItem: Build,
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: Build,
        newItem: Build,
    ): Boolean = oldItem == newItem
}
