package com.example.data.repositories

import com.example.data.dao.PsuDAO
import com.example.data.entities.PSUEntity
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import com.example.domain.entities.PSU
import com.example.domain.repositories.PsuRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PsuRepositoryImpl @Inject constructor(private val psuDAO: PsuDAO) : PsuRepository {
    override fun getPsus(): Flow<List<PSU>> =
        psuDAO.getPsu().map { it.map(PSUEntity::toDomain) }

    override suspend fun getPsu(id: Int): PSU =
        psuDAO.getPsu(id).toDomain()

    override suspend fun updatePsu(psu: PSU) {
        psuDAO.updatePsu(psu.toData())
    }

    override suspend fun toggleFavorite(item: PSU) {
        psuDAO.updatePsu(item.toData())
    }
}
