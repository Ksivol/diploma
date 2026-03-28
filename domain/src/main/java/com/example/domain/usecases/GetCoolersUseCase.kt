package com.example.domain.usecases

import com.example.domain.entities.Cooler
import com.example.domain.repositories.CoolerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoolersUseCase @Inject constructor(private val repository: CoolerRepository) {
    operator fun invoke(): Flow<List<Cooler>> = repository.getCoolers()
}
