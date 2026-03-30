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

    override fun getMotherboard(id: Int): Motherboard =
        motherboardDAO.getMotherboard(id).toDomain()

    override fun updateMotherboard(motherboard: Motherboard) {
        motherboardDAO.updateMotherboard(motherboard.toData())
    }
}
