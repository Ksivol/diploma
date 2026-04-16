package com.example.domain.repositories

import com.example.domain.entities.CPU
import com.example.domain.entities.HardDrive
import kotlinx.coroutines.flow.Flow

interface HardDriveRepository: BaseRepository<HardDrive> {
    fun getHardDrives(): Flow<List<HardDrive>>

    suspend fun getHardDrive(id: Int): HardDrive

    suspend fun updateHardDrive(hardDrive: HardDrive)
}
