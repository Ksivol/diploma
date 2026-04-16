package com.example.domain.repositories

import com.example.domain.entities.CPU
import com.example.domain.entities.PSU
import kotlinx.coroutines.flow.Flow

interface PsuRepository: BaseRepository<PSU> {
    fun getPsus(): Flow<List<PSU>>

    suspend fun getPsu(id: Int): PSU

    suspend fun updatePsu(psu: PSU)
}
