package com.example.domain.repositories

import com.example.domain.entities.Cooler
import kotlinx.coroutines.flow.Flow

interface CoolerRepository: BaseRepository<Cooler> {
    fun getCoolers(): Flow<List<Cooler>>

    suspend fun getCooler(id: Int): Cooler

    suspend fun updateCooler(cooler: Cooler)
}
