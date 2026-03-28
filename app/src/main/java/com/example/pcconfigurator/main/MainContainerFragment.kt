package com.example.pcconfigurator.main

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentMainContainerBinding
import com.example.pcconfigurator.di.component
import com.example.pcconfigurator.features.favoritesfeature.favorites.FavoritesFragment
import com.example.pcconfigurator.features.pcbuildsfeature.builds.BuildsFragment
import com.example.pcconfigurator.utils.FragmentNavigator
import com.github.terrakok.cicerone.NavigatorHolder
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainContainerFragment : Fragment(R.layout.fragment_main_container) {
    private val binding: FragmentMainContainerBinding by viewBinding(FragmentMainContainerBinding::bind)
    @Inject lateinit var factory: ViewModelProvider.Factory
    @Inject lateinit var navigatorHolder: NavigatorHolder
    private val mainViewModel: MainViewModel by activityViewModels { factory }
    private val mainContainerViewModel: MainContainerViewModel by viewModels { factory }
    private val fragmentNavigator: FragmentNavigator by lazy {
        FragmentNavigator(R.id.mainContainer,this::class.simpleName.toString(), childFragmentManager,)
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
        edgeToEdgeSettings()
        setupBottomMenu()
        setupTitle()
        onBackPressed()
        onNavigationToBuildScreen()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(fragmentNavigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
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
        binding.navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.builds -> {
                    mainContainerViewModel.navigateTo(BuildsFragment.Screen())
                    true
                }
                R.id.favorites -> {
                    mainContainerViewModel.navigateTo(FavoritesFragment.Screen())
                    true
                }
                R.id.profile -> true
                R.id.categories -> true
                else -> false
            }

        }
    }

    private suspend fun setTitle() {
        mainViewModel.title.collect {
            binding.title.text = it
        }
    }

    private fun onNavigationToBuildScreen() {
        mainContainerViewModel.navigateTo(BuildsFragment.Screen())
    }

    private fun onBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            if (childFragmentManager.backStackEntryCount > 1) mainContainerViewModel.back()
            else requireActivity().finish()
        }
    }
}
