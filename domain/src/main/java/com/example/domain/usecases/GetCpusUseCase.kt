package com.example.domain.usecases

import com.example.domain.entities.CPU
import com.example.domain.repositories.CpuRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCpusUseCase @Inject constructor(private val repository: CpuRepository) {
    operator fun invoke(): Flow<List<CPU>> = repository.getCpus()
}
