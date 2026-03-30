package com.example.domain.usecases

import com.example.domain.entities.CPU
import com.example.domain.repositories.CpuRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCpusUseCase @Inject constructor(private val repository: CpuRepository) {
    suspend operator fun invoke(): Flow<List<CPU>> = withContext(Dispatchers.IO) { repository.getCpus() }
}
