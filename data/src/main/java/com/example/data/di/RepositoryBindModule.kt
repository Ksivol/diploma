package com.example.data.di

import com.example.data.repositories.CoolerRepositoryImpl
import com.example.data.repositories.CpuRepositoryImpl
import com.example.data.repositories.HardDriveRepositoryImpl
import com.example.data.repositories.MotherboardRepositoryImpl
import com.example.data.repositories.PcCaseRepositoryImpl
import com.example.data.repositories.PcRepositoryImpl
import com.example.data.repositories.PsuRepositoryImpl
import com.example.data.repositories.RamRepositoryImpl
import com.example.data.repositories.VideoCardRepositoryImpl
import com.example.domain.repositories.CoolerRepository
import com.example.domain.repositories.CpuRepository
import com.example.domain.repositories.HardDriveRepository
import com.example.domain.repositories.MotherboardRepository
import com.example.domain.repositories.PcCaseRepository
import com.example.domain.repositories.PcRepository
import com.example.domain.repositories.PsuRepository
import com.example.domain.repositories.RamRepository
import com.example.domain.repositories.VideoCardRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryBindModule {
    @Binds
    fun bindCoolerRepository(coolerRepositoryImpl: CoolerRepositoryImpl): CoolerRepository

    @Binds
    fun bindCpuRepository(cpuRepositoryImpl: CpuRepositoryImpl): CpuRepository

    @Binds
    fun bindHardDriveRepository(dardDriveRepositoryImpl: HardDriveRepositoryImpl): HardDriveRepository

    @Binds
    fun bindMotherboardRepository(motherboardRepositoryImpl: MotherboardRepositoryImpl): MotherboardRepository

    @Binds
    fun bindPcCaseRepository(pcCaseRepositoryImpl: PcCaseRepositoryImpl): PcCaseRepository

    @Binds
    fun bindPcRepository(pcRepositoryImpl: PcRepositoryImpl): PcRepository

    @Binds
    fun bindPsuRepository(psuRepositoryImpl: PsuRepositoryImpl): PsuRepository

    @Binds
    fun bindRamRepository(ramRepositoryImpl: RamRepositoryImpl): RamRepository

    @Binds
    fun bindVideoCardRepository(videoCardRepositoryImpl: VideoCardRepositoryImpl): VideoCardRepository
}
