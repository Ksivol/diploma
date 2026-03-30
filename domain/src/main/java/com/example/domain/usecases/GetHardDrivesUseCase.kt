package com.example.domain.usecases

import com.example.domain.entities.HardDrive
import com.example.domain.repositories.HardDriveRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetHardDrivesUseCase @Inject constructor(private val repository: HardDriveRepository) {
    suspend operator fun invoke(): Flow<List<HardDrive>> = withContext(Dispatchers.IO) { repository.getHardDrives() }
}
