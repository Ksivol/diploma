package com.example.domain.usecases

import com.example.domain.enitities.Pc
import com.example.domain.repositories.PcRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBuildsUseCase
    @Inject
    constructor(
        private val pcRepository: PcRepository,
    ) {
        fun execute(): Flow<List<Pc>> = pcRepository.getPc()
    }
