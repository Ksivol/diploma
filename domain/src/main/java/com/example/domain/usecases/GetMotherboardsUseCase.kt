package com.example.domain.usecases

import com.example.domain.entities.Motherboard
import com.example.domain.repositories.MotherboardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMotherboardsUseCase @Inject constructor(private val repository: MotherboardRepository) {
    suspend operator fun invoke(): Flow<List<Motherboard>> = withContext(Dispatchers.IO) { repository.getMotherboards() }
}
