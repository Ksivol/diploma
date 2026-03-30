package com.example.domain.usecases

import com.example.domain.entities.RAM
import com.example.domain.repositories.RamRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetRamsUseCase @Inject constructor(private val repository: RamRepository) {
    suspend operator fun invoke(): Flow<List<RAM>> = withContext(Dispatchers.IO) { repository.getRams() }
}
