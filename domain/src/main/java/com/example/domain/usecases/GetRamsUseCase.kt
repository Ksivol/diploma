package com.example.domain.usecases

import com.example.domain.entities.RAM
import com.example.domain.repositories.RamRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRamsUseCase @Inject constructor(private val repository: RamRepository) {
    operator fun invoke(): Flow<List<RAM>> = repository.getRams()
}
