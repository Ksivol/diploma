package com.example.domain.usecases

import com.example.domain.entities.PcCase
import com.example.domain.repositories.PcCaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPcCasesUseCase @Inject constructor(private val repository: PcCaseRepository) {
    operator fun invoke(): Flow<List<PcCase>> = repository.getPcCases()
}
