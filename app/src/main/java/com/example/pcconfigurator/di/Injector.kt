package com.example.pcconfigurator.di

import com.example.pcconfigurator.features.categories.CategoriesFragment
import com.example.pcconfigurator.features.favorites.FavoritesFragment
import com.example.pcconfigurator.features.pcBuilds.BuildsFragment
import com.example.pcconfigurator.features.profile.ProfileFragment
import com.example.pcconfigurator.main.App
import com.example.pcconfigurator.main.MainContainerFragment

fun BuildsFragment.inject() {
    (requireContext().applicationContext as App)
        .component
        .inject(this)
}

fun CategoriesFragment.inject() {
    (requireContext().applicationContext as App)
        .component
        .inject(this)
}

fun FavoritesFragment.inject() {
    (requireContext().applicationContext as App)
        .component
        .inject(this)
}

fun ProfileFragment.inject() {
    (requireContext().applicationContext as App)
        .component
        .inject(this)
}

fun MainContainerFragment.inject() {
    (requireContext().applicationContext as App)
        .component
        .inject(this)
}
