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
import com.example.domain.entities.CPU
import com.example.domain.entities.Cooler
import com.example.domain.entities.HardDrive
import com.example.domain.entities.Motherboard
import com.example.domain.entities.PSU
import com.example.domain.entities.PcCase
import com.example.domain.entities.RAM
import com.example.domain.entities.VideoCard
import com.example.domain.repositories.BaseRepository
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

    @Binds
    fun bindCoolerRepositoryToBaseRepository(coolerRepositoryImpl: CoolerRepositoryImpl): BaseRepository<Cooler>

    @Binds
    fun bindCpuRepositoryToBaseRepository(cpuRepositoryImpl: CpuRepositoryImpl): BaseRepository<CPU>

    @Binds
    fun bindHardDriveRepositoryToBaseRepository(dardDriveRepositoryImpl: HardDriveRepositoryImpl): BaseRepository<HardDrive>

    @Binds
    fun bindMotherboardRepositoryToBaseRepository(motherboardRepositoryImpl: MotherboardRepositoryImpl): BaseRepository<Motherboard>

    @Binds
    fun bindPcCaseRepositoryToBaseRepository(pcCaseRepositoryImpl: PcCaseRepositoryImpl): BaseRepository<PcCase>

    @Binds
    fun bindPsuRepositoryToBaseRepository(psuRepositoryImpl: PsuRepositoryImpl): BaseRepository<PSU>

    @Binds
    fun bindRamRepositoryToBaseRepository(ramRepositoryImpl: RamRepositoryImpl): BaseRepository<RAM>

    @Binds
    fun bindVideoCardRepositoryToBaseRepository(videoCardRepositoryImpl: VideoCardRepositoryImpl): BaseRepository<VideoCard>
}