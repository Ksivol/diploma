package com.example.pcconfigurator.di

import com.example.pcconfigurator.features.pcBuilds.BuildsFragment
import com.example.pcconfigurator.main.App

fun BuildsFragment.inject() {
    (requireContext().applicationContext as App)
        .component
        .inject(this)
}
