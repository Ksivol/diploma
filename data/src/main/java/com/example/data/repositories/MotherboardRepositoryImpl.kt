package com.example.data.repositories

import com.example.data.dao.MotherboardDAO
import com.example.data.entities.MotherboardEntity
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import com.example.domain.enitities.Motherboard
import com.example.domain.repositories.MotherboardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MotherboardRepositoryImpl(private val motherboardDAO: MotherboardDAO) : MotherboardRepository {
    override fun getMotherboards(): Flow<List<Motherboard>> = motherboardDAO.getMotherboards().map { it.map(MotherboardEntity::toDomain) }

    override fun insertMotherboard(motherboard: Motherboard) {
        motherboardDAO.insertMotherboard(motherboard.toData())
    }

    override fun updateMotherboard(motherboard: Motherboard) {
        motherboardDAO.updateMotherboard(motherboard.toData())
    }

    override fun deleteMotherboard(motherboard: Motherboard) {
        motherboardDAO.deleteMotherboard(motherboard.toData())
    }
}
