package com.example.data.repositories

import com.example.data.dao.CpuDAO
import com.example.data.entities.CPUEntity
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import com.example.domain.entities.CPU
import com.example.domain.repositories.CpuRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CpuRepositoryImpl @Inject constructor(private val cpuDAO: CpuDAO) : CpuRepository {
    override fun getCpus(): Flow<List<CPU>> =
        cpuDAO.getCpus().map { it.map(CPUEntity::toDomain) }

    override suspend fun getCpu(id: Int): CPU =
        cpuDAO.getCpu(id).toDomain()

    override suspend fun updateCpu(cpu: CPU) {
        cpuDAO.updateCpu(cpu.toData())
    }

    override suspend fun toggleFavorite(item: CPU) {
        cpuDAO.updateCpu(item.toData())
    }
}
