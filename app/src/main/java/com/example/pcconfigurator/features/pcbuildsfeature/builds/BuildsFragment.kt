package com.example.pcconfigurator.features.pcbuildsfeature.builds

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentHostCallback
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentBuildsBinding
import com.example.pcconfigurator.di.component
import com.example.pcconfigurator.features.pcbuildsfeature.utils.BuildsAdapter
import com.example.pcconfigurator.main.MainViewModel
import com.github.terrakok.cicerone.androidx.FragmentScreen
import kotlinx.coroutines.launch
import javax.inject.Inject

class BuildsFragment : Fragment(R.layout.fragment_builds) {
    private val binding: FragmentBuildsBinding by viewBinding(FragmentBuildsBinding::bind)
    private val mainViewModel: MainViewModel by activityViewModels { factory }
    private val viewModel: BuildsViewModel by viewModels { factory }
    @Inject lateinit var factory: ViewModelProvider.Factory

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
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        setTitle()
        initAdapter()
        setData()
        onCreateBuildTouch()
    }

    private fun initAdapter() =
        with(binding) {
            buildsRecyclerView.adapter = adapter
        }

    private fun setData() {
        lifecycleScope.launch {
            viewModel.builds.collect { pcList ->
                adapter.submitList(pcList)
            }
        }
    }

    private fun setTitle() {
        mainViewModel.setTitle(requireContext().getString(R.string.builds))
    }

    private fun onCreateBuildTouch() {
        binding.createBuild.setOnClickListener {
            viewModel.navigateToMakeABuild()
        }
    }

    class Screen() : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment = BuildsFragment()
    }
}
