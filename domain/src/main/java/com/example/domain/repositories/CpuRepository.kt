package com.example.domain.repositories

import com.example.domain.entities.CPU
import kotlinx.coroutines.flow.Flow

interface CpuRepository {
    fun getCpus(): Flow<List<CPU>>

    fun getCpu(id: Int): CPU

    fun updateCpu(cpu: CPU)
}
