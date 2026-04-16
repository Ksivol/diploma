package com.example.data.repositories

import com.example.data.dao.PcCaseDAO
import com.example.data.entities.PcCaseEntity
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import com.example.domain.entities.PcCase
import com.example.domain.repositories.PcCaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PcCaseRepositoryImpl @Inject constructor(private val pcCaseDAO: PcCaseDAO) : PcCaseRepository {
    override fun getPcCases(): Flow<List<PcCase>> =
        pcCaseDAO.getPcCases().map { it.map(PcCaseEntity::toDomain) }

    override suspend fun getPcCase(id: Int): PcCase =
        pcCaseDAO.getPcCase(id).toDomain()

    override suspend fun updatePcCase(pcCase: PcCase) {
        pcCaseDAO.updatePcCase(pcCase.toData())
    }

    override suspend fun toggleFavorite(item: PcCase) {
        pcCaseDAO.updatePcCase(item.toData())
    }
}
