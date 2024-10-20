package com.example.domain.repositories

import com.example.domain.enitities.Pc
import com.example.domain.enitities.PcCase
import kotlinx.coroutines.flow.Flow

interface PcRepository {
    fun getPc(): Flow<List<Pc>>

    fun getPc(id: Int): Pc

    fun insertPc(pc: Pc)

    fun updatePc(pc: Pc)

    fun deletePc(pc: Pc)
}