package com.example.domain.repositories

import com.example.domain.entities.CPU
import kotlinx.coroutines.flow.Flow

interface CpuRepository: BaseRepository<CPU> {
    fun getCpus(): Flow<List<CPU>>

    suspend fun getCpu(id: Int): CPU

    suspend fun updateCpu(cpu: CPU)
}
