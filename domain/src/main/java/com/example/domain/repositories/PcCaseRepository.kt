package com.example.domain.repositories

import com.example.domain.entities.PcCase
import kotlinx.coroutines.flow.Flow

interface PcCaseRepository {
    fun getPcCases(): Flow<List<PcCase>>

    fun getPcCase(id: Int): PcCase

    fun updatePcCase(pcCase: PcCase)
}
