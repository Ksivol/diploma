package com.example.domain.repositories

import com.example.domain.entities.CPU
import com.example.domain.entities.PcCase
import kotlinx.coroutines.flow.Flow

interface PcCaseRepository: BaseRepository<PcCase> {
    fun getPcCases(): Flow<List<PcCase>>

    suspend fun getPcCase(id: Int): PcCase

    suspend fun updatePcCase(pcCase: PcCase)
}

