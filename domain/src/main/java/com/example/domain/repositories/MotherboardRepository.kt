package com.example.domain.repositories

import com.example.domain.enitities.Motherboard
import kotlinx.coroutines.flow.Flow

interface MotherboardRepository {
    fun getMotherboards(): Flow<List<Motherboard>>

    fun insertMotherboard(motherboard: Motherboard)

    fun updateMotherboard(motherboard: Motherboard)

    fun deleteMotherboard(motherboard: Motherboard)
}
