package com.example.pcconfigurator.pcBuilds

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentBuildsBinding
import com.example.pcconfigurator.di.inject
import com.example.pcconfigurator.utils.BuildsAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

class BuildsFragment : Fragment(R.layout.fragment_builds) {
    private val binding: FragmentBuildsBinding by viewBinding(FragmentBuildsBinding::bind)

    private val viewModel: BuildsViewModel by viewModels {
        factory
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val adapter: BuildsAdapter by lazy {
        BuildsAdapter(
            onEdit = {
                Toast
                    .makeText(
                        requireContext(),
                        "Probably, we can edit it,\nbut it's not realized.\nI need more time",
                        Toast.LENGTH_SHORT,
                    ).show()
            },
            onDelete = {
                Toast
                    .makeText(
                        requireContext(),
                        "Probably, we can delete it,\nbut it's not realized.\nI need more time",
                        Toast.LENGTH_SHORT,
                    ).show()
            },
        )
    }

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        setData()
        onCreateBuildTouch()
    }

    private fun initAdapter() =
        with(binding) {
            buildsRV.layoutManager = LinearLayoutManager(requireContext())
            buildsRV.adapter = adapter
        }

    private fun setData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.builds.collect { pcList ->
                    adapter.submitList(pcList)
                }
            }
        }
    }

    private fun onCreateBuildTouch() {
        binding.createBuild.setOnClickListener {
            Toast
                .makeText(
                    requireContext(),
                    "Seems like we still can't add some pc build...\n " +
                        "Maybe u should wait a little bit more? (please) :)",
                    Toast.LENGTH_SHORT,
                ).show()
        }
    }
}
