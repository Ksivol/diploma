package com.example.domain.repositories

import com.example.domain.entities.RAM
import kotlinx.coroutines.flow.Flow

interface RamRepository {
    fun getRams(): Flow<List<RAM>>

    fun getRam(id: Int): RAM

    fun updateRam(ram: RAM)
}
