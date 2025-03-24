package com.example.pcconfigurator.main

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class MainContainerViewModel @Inject constructor(private val router: Router) : ViewModel() {

    fun navigateTo(screen: FragmentScreen) {
        router.replaceScreen(screen)
    }

    fun back() {
        router.exit()
    }
}