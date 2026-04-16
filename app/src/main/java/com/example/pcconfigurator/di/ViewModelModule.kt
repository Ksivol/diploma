package com.example.pcconfigurator.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pcconfigurator.features.categoriesfeature.categories.cooler.CoolerListViewModel
import com.example.pcconfigurator.features.categoriesfeature.categories.cpu.CpuListViewModel
import com.example.pcconfigurator.features.categoriesfeature.categories.hardDrive.HardDriveListViewModel
import com.example.pcconfigurator.features.categoriesfeature.categories.mothervoard.MotherboardListViewModel
import com.example.pcconfigurator.features.categoriesfeature.categories.psCase.PcCaseListViewModel
import com.example.pcconfigurator.features.categoriesfeature.categories.psu.PsuListViewModel
import com.example.pcconfigurator.features.categoriesfeature.categories.ram.RamListViewModel
import com.example.pcconfigurator.features.categoriesfeature.categories.videoCard.VideoCardListViewModel
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
    @[IntoMap ViewModelKey(CoolerListViewModel::class)]
    fun bindCoolerViewModel(coolerListViewModel: CoolerListViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(CpuListViewModel::class)]
    fun bindCpuViewModel(cpuListViewModel: CpuListViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(HardDriveListViewModel::class)]
    fun bindHardDriveViewModel(hardDriveListViewModel: HardDriveListViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(MotherboardListViewModel::class)]
    fun bindMotherboardViewModel(motherboardListViewModel: MotherboardListViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(PcCaseListViewModel::class)]
    fun bindPcCaseViewModel(pcCaseListViewModel: PcCaseListViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(PsuListViewModel::class)]
    fun bindPsuViewModel(psuListViewModel: PsuListViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(RamListViewModel::class)]
    fun bindRamViewModel(ramListViewModel: RamListViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(VideoCardListViewModel::class)]
    fun bindVideoCardViewModel(videoCardListViewModel: VideoCardListViewModel): ViewModel
}
