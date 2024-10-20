package com.example.domain.repositories

import com.example.domain.enitities.CPU
import kotlinx.coroutines.flow.Flow

interface CpuRepository {
    fun getCpus(): Flow<List<CPU>>

    fun getCpu(id: Int): CPU

    fun insertCpu(cpu: CPU)

    fun updateCpu(cpu: CPU)

    fun deleteCpu(cpu: CPU)
}
