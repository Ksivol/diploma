package com.example.pcconfigurator.features.pcbuildsfeature.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pcconfigurator.databinding.BuildItemBinding
import com.example.pcconfigurator.features.pcbuildsfeature.models.Build
import com.example.pcconfigurator.features.pcbuildsfeature.utils.BuildsAdapter.BuildHolder

class BuildsAdapter(
    private val onEdit: (Build) -> Unit,
    private val onDelete: (Build) -> Unit,
) : ListAdapter<Build, BuildHolder>(BuildComparator()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BuildHolder {
        return BuildHolder(
            BuildItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(
        holder: BuildHolder,
        position: Int,
    ): Unit {
        holder.onBind(getItem(position))
    }

    inner class BuildHolder(
        private val binding: BuildItemBinding
    ) : ViewHolder(binding.root) {
        private var currentBuild: Build? = null

        init {
            binding.editBuildCV.setOnClickListener {
                currentBuild?.let {
                    onEdit(it)
                }
            }
            binding.deleteBuildCV.setOnClickListener {
                currentBuild?.let {
                    onDelete(it)
                }
            }
        }

        fun onBind(build: Build): Unit {
            currentBuild = build
            binding.buildItemTV.text = build.title
        }
    }
}

class BuildComparator : DiffUtil.ItemCallback<Build>() {
    override fun areItemsTheSame(
        oldItem: Build,
        newItem: Build,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Build,
        newItem: Build,
    ): Boolean {
        return oldItem == newItem
    }
}
