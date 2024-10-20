package com.example.domain.repositories

import com.example.domain.enitities.Cooler
import kotlinx.coroutines.flow.Flow

interface CoolerRepository {
    fun getCoolers(): Flow<List<Cooler>>

    fun getCooler(id: Int): Cooler

    fun insertCooler(cooler: Cooler)

    fun updateCooler(cooler: Cooler)

    fun deleteCooler(cooler: Cooler)
}
