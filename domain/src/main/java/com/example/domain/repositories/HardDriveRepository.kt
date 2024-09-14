package com.example.domain.repositories

import com.example.domain.enitities.HardDrive
import kotlinx.coroutines.flow.Flow

interface HardDriveRepository {
    fun getHardDrives(): Flow<List<HardDrive>>

    fun insertHardDrive(hardDrive: HardDrive)

    fun updateHardDrive(hardDrive: HardDrive)

    fun deleteHardDrive(hardDrive: HardDrive)
}
