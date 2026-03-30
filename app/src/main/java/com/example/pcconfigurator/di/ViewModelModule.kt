package com.example.pcconfigurator.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pcconfigurator.features.categoriesfeature.categories.CoolerViewModel
import com.example.pcconfigurator.features.categoriesfeature.categories.CpuViewModel
import com.example.pcconfigurator.features.categoriesfeature.categories.HardDriveViewModel
import com.example.pcconfigurator.features.categoriesfeature.categories.MotherboardViewModel
import com.example.pcconfigurator.features.categoriesfeature.categories.PcCaseViewModel
import com.example.pcconfigurator.features.categoriesfeature.categories.PsuViewModel
import com.example.pcconfigurator.features.categoriesfeature.categories.RamViewModel
import com.example.pcconfigurator.features.categoriesfeature.categories.VideoCardViewModel
import com.example.pcconfigurator.features.pcbuildsfeature.builds.BuildsViewModel
import com.example.pcconfigurator.main.MainContainerViewModel
import com.example.pcconfigurator.main.MainViewModel
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

    @Binds
    @[IntoMap ViewModelKey(MainViewModel::class)]
    fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(MainContainerViewModel::class)]
    fun bindMainContainerViewModel(mainContainerViewModel: MainContainerViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(CoolerViewModel::class)]
    fun bindCoolerViewModel(coolerViewModel: CoolerViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(CpuViewModel::class)]
    fun bindCpuViewModel(cpuViewModel: CpuViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(HardDriveViewModel::class)]
    fun bindHardDriveViewModel(hardDriveViewModel: HardDriveViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(MotherboardViewModel::class)]
    fun bindMotherboardViewModel(motherboardViewModel: MotherboardViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(PcCaseViewModel::class)]
    fun bindPcCaseViewModel(pcCaseViewModel: PcCaseViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(PsuViewModel::class)]
    fun bindPsuViewModel(psuViewModel: PsuViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(RamViewModel::class)]
    fun bindRamViewModel(ramViewModel: RamViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(VideoCardViewModel::class)]
    fun bindVideoCardViewModel(videoCardViewModel: VideoCardViewModel): ViewModel
}
