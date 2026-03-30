package com.example.data.repositories

import com.example.data.dao.HardDriveDAO
import com.example.data.entities.HardDriveEntity
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import com.example.domain.entities.HardDrive
import com.example.domain.repositories.HardDriveRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HardDriveRepositoryImpl @Inject constructor(private val hardDriveDAO: HardDriveDAO) : HardDriveRepository {
    override fun getHardDrives(): Flow<List<HardDrive>> =
        hardDriveDAO.getHardDrives().map { it.map(HardDriveEntity::toDomain) }

    override fun getHardDrive(id: Int): HardDrive =
        hardDriveDAO.getHardDrive(id).toDomain()

    override fun updateHardDrive(hardDrive: HardDrive) {
        hardDriveDAO.updateHardDrive(hardDrive.toData())
    }
}
