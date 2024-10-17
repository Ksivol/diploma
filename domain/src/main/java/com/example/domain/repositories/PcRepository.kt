package com.example.domain.repositories

import com.example.domain.enitities.Pc
import kotlinx.coroutines.flow.Flow

interface PcRepository {
    fun getPc(): Flow<List<Pc>>

    fun insertPc(pc: Pc)

    fun updatePc(pc: Pc)

    fun deletePc(pc: Pc)
}