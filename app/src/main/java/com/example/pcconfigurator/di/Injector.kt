package com.example.pcconfigurator.di

import com.example.pcconfigurator.main.App
import com.example.pcconfigurator.pcBuilds.BuildsFragment

fun BuildsFragment.inject() {
    (requireContext().applicationContext as App)
        .component
        .inject(this)
}
