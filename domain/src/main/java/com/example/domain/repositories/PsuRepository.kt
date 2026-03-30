package com.example.domain.repositories

import com.example.domain.entities.PSU
import kotlinx.coroutines.flow.Flow

interface PsuRepository {
    fun getPsus(): Flow<List<PSU>>

    fun getPsu(id: Int): PSU

    fun updatePsu(psu: PSU)
}
