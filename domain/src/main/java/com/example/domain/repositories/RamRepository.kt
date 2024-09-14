package com.example.domain.repositories

import com.example.domain.enitities.RAM
import kotlinx.coroutines.flow.Flow

interface RamRepository {
    fun getRams(): Flow<List<RAM>>

    fun insertRam(ram: RAM)

    fun updateRam(ram: RAM)

    fun deleteRam(ram: RAM)
}
