package com.example.domain.repositories

import com.example.domain.enitities.PSU
import kotlinx.coroutines.flow.Flow

interface PsuRepository {
    fun getPsuList(): Flow<List<PSU>>

    fun getPsu(id: Int): PSU

    fun insertPsu(psu: PSU)

    fun updatePsu(psu: PSU)

    fun deletePsu(psu: PSU)
}
