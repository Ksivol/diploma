package com.example.pcconfigurator.main

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentMainContainerBinding
import com.example.pcconfigurator.di.inject
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainContainerFragment : Fragment(R.layout.fragment_main_container) {
    private val binding: FragmentMainContainerBinding by viewBinding(FragmentMainContainerBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by activityViewModels {
        factory
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
        edgeToEdgeSettings()
        setupBottomMenu()
        setupTitle()
    }

    private fun setupTitle() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch { setTitle() }
            }
        }
    }

    private fun edgeToEdgeSettings() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.mainContainerFragment) { v, insets ->
            insets
                .getInsets(WindowInsetsCompat.Type.statusBars())
                .apply { v.setPadding(0, top, 0, 0) }
            insets
        }
    }

    private fun setupBottomMenu() {
        binding.navigation.setupWithNavController(binding.mainContainer.getFragment<NavHostFragment>().navController)
    }

    private suspend fun setTitle() {
        viewModel.title.collect {
            binding.title.text = it
        }
    }
}
