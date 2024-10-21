package com.example.pcconfigurator.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pcconfigurator.pcBuilds.BuildsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @[IntoMap ViewModelKey(BuildsViewModel::class)]
    fun bindBuildsViewModel(buildsViewModel: BuildsViewModel): ViewModel
}
