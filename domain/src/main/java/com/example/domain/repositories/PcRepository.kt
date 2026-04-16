package com.example.domain.repositories

import com.example.domain.entities.Pc
import kotlinx.coroutines.flow.Flow

interface PcRepository {
    fun getPc(): Flow<List<Pc>>

    suspend fun getPc(id: Int): Pc

    suspend fun updatePc(pc: Pc)
}
