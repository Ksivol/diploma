package com.example.domain.repositories

import com.example.domain.entities.CPU
import com.example.domain.entities.RAM
import kotlinx.coroutines.flow.Flow

interface RamRepository: BaseRepository<RAM> {
    fun getRams(): Flow<List<RAM>>

    suspend fun getRam(id: Int): RAM

    suspend fun updateRam(ram: RAM)
}
