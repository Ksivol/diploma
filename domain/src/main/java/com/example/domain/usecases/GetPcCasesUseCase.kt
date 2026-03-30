package com.example.domain.usecases

import com.example.domain.entities.PcCase
import com.example.domain.repositories.PcCaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPcCasesUseCase @Inject constructor(private val repository: PcCaseRepository) {
    suspend operator fun invoke(): Flow<List<PcCase>> = withContext(Dispatchers.IO) { repository.getPcCases() }
}
