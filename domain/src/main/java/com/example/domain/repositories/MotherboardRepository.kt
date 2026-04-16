package com.example.domain.repositories

import com.example.domain.entities.CPU
import com.example.domain.entities.Motherboard
import kotlinx.coroutines.flow.Flow

interface MotherboardRepository: BaseRepository<Motherboard> {
    fun getMotherboards(): Flow<List<Motherboard>>

    suspend fun getMotherboard(id: Int): Motherboard

    suspend fun updateMotherboard(motherboard: Motherboard)
}
