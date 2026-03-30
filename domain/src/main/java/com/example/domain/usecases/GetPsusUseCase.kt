package com.example.domain.usecases

import com.example.domain.entities.PSU
import com.example.domain.repositories.PsuRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPsusUseCase @Inject constructor(private val repository: PsuRepository) {
    suspend operator fun invoke(): Flow<List<PSU>> = withContext(Dispatchers.IO) { repository.getPsus() }
}
