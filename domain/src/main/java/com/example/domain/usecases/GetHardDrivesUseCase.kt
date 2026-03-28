package com.example.domain.usecases

import com.example.domain.entities.HardDrive
import com.example.domain.repositories.HardDriveRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHardDrivesUseCase @Inject constructor(private val repository: HardDriveRepository) {
    operator fun invoke(): Flow<List<HardDrive>> = repository.getHardDrives()
}
