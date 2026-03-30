package com.example.domain.usecases

import com.example.domain.entities.Cooler
import com.example.domain.repositories.CoolerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCoolersUseCase @Inject constructor(private val repository: CoolerRepository) {
    suspend operator fun invoke(): Flow<List<Cooler>> = withContext(Dispatchers.IO) {repository.getCoolers()}
}
