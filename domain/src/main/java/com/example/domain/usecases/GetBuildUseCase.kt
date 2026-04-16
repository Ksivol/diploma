package com.example.domain.usecases

import com.example.domain.entities.Pc
import com.example.domain.repositories.PcRepository
import javax.inject.Inject

class GetBuildUseCase @Inject constructor(private val pcRepository: PcRepository) {

    suspend fun execute(id: Int): Pc {
        return pcRepository.getPc(id)
    }
}