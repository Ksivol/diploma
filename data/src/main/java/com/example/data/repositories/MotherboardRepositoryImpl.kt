package com.example.data.repositories

import com.example.data.dao.MotherboardDAO
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import com.example.domain.entities.Motherboard
import com.example.domain.repositories.MotherboardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MotherboardRepositoryImpl @Inject constructor(private val motherboardDAO: MotherboardDAO) : MotherboardRepository {
    override fun getMotherboards(): Flow<List<Motherboard>> =
        motherboardDAO.getMotherboards().map { it.map { it.toDomain() } }

    override suspend fun getMotherboard(id: Int): Motherboard =
        motherboardDAO.getMotherboard(id).toDomain()

    override suspend fun updateMotherboard(motherboard: Motherboard) {
        motherboardDAO.updateMotherboard(motherboard.toData())
    }

    override suspend fun toggleFavorite(item: Motherboard) {
        motherboardDAO.updateMotherboard(item.toData())
    }
}
