package com.example.pcconfigurator.main

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentMainContainerBinding
import com.example.pcconfigurator.di.inject

class MainContainerFragment : Fragment(R.layout.fragment_main_container) {
    private val binding: FragmentMainContainerBinding by viewBinding(FragmentMainContainerBinding::bind)

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
        setupBottomMenuNavController()
        setupToolbarNavController()
    }

    private fun setupToolbarNavController() {
        binding.toolbar.setupWithNavController(
            binding.mainContainer.getFragment<NavHostFragment>().navController,
            AppBarConfiguration(setOf(R.id.builds, R.id.categories, R.id.profile, R.id.favorites)),
        )
    }

    private fun edgeToEdgeSettings() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.mainContainerFragment) { v, insets ->
            insets
                .getInsets(WindowInsetsCompat.Type.statusBars())
                .apply { v.setPadding(0, top, 0, 0) }
            insets
        }
    }

    private fun setupBottomMenuNavController() {
        binding.navigation.setupWithNavController(binding.mainContainer.getFragment<NavHostFragment>().navController)
    }
}
