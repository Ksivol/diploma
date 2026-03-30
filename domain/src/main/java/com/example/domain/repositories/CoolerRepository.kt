package com.example.domain.repositories

import com.example.domain.entities.Cooler
import kotlinx.coroutines.flow.Flow

interface CoolerRepository {
    fun getCoolers(): Flow<List<Cooler>>

    fun getCooler(id: Int): Cooler

    fun updateCooler(cooler: Cooler)
}
