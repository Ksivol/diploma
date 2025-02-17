package com.example.pcconfigurator.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pcconfigurator.databinding.BuildItemBinding
import com.example.pcconfigurator.models.Build

class BuildsAdapter(
    private val onEdit: () -> Unit,
    private val onDelete: () -> Unit,
) : ListAdapter<Build, BuildHolder>(BuildComparator()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BuildHolder =
        BuildHolder(
            BuildItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            onEdit,
            onDelete,
        )

    override fun onBindViewHolder(
        holder: BuildHolder,
        position: Int,
    ) {
        holder.onBind(getItem(position))
    }
}

class BuildHolder(
    private val binding: BuildItemBinding,
    private val onEdit: () -> Unit,
    private val onDelete: () -> Unit,
) : ViewHolder(binding.root) {
    fun onBind(build: Build) =
        with(binding) {
            buildItemTV.text = build.title
            editBuildCV.setOnClickListener {
                onEdit.invoke()
            }
            deleteBuildCV.setOnClickListener {
                onDelete.invoke()
            }
        }
}

class BuildComparator : DiffUtil.ItemCallback<Build>() {
    override fun areItemsTheSame(
        oldItem: Build,
        newItem: Build,
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: Build,
        newItem: Build,
    ): Boolean = oldItem == newItem
}
