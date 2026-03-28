package com.example.domain.usecases

import com.example.domain.entities.Pc
import com.example.domain.repositories.PcRepository

class GetBuildUseCase(private val pcRepository: PcRepository) {

    fun execute(id: Int): Pc {
        return pcRepository.getPc(id)
    }
}