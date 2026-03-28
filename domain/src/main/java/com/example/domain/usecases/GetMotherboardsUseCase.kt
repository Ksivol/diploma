package com.example.domain.usecases

import com.example.domain.entities.Motherboard
import com.example.domain.repositories.MotherboardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMotherboardsUseCase @Inject constructor(private val repository: MotherboardRepository) {
    operator fun invoke(): Flow<List<Motherboard>> = repository.getMotherboards()
}
