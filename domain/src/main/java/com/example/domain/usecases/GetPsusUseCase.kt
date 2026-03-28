package com.example.domain.usecases

import com.example.domain.entities.PSU
import com.example.domain.repositories.PsuRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPsusUseCase @Inject constructor(private val repository: PsuRepository) {
    operator fun invoke(): Flow<List<PSU>> = repository.getPsus()
}
