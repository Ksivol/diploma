package com.example.domain.repositories

import com.example.domain.enitities.PcCase
import kotlinx.coroutines.flow.Flow

interface PcCaseRepository {
    fun getPcCases(): Flow<List<PcCase>>

    fun insertPcCase(pcCase: PcCase)

    fun updatePcCase(pcCase: PcCase)

    fun deletePcCase(pcCase: PcCase)
}
