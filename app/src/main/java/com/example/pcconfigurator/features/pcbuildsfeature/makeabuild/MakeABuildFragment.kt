package com.example.pcconfigurator.features.pcbuildsfeature.makeabuild

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentMakeABuildBinding
import com.example.pcconfigurator.di.component
import com.example.pcconfigurator.features.pcbuildsfeature.utils.BuildComponentAdapter
import com.example.pcconfigurator.main.MainViewModel
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class MakeABuildFragment : Fragment(R.layout.fragment_make_a_build) {
    private val binding: FragmentMakeABuildBinding by viewBinding(FragmentMakeABuildBinding::bind)
    private val mainViewModel: MainViewModel by activityViewModels()
    private val adapter: BuildComponentAdapter = BuildComponentAdapter()

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle()
        initAdapter()
    }

    private fun initAdapter() {
        binding.componentsRecyclerView.adapter = adapter
    }

    private fun setTitle() {
        mainViewModel.setTitle(requireContext().getString(R.string.make_a_build))
    }

    class Screen : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment = MakeABuildFragment()
    }
}