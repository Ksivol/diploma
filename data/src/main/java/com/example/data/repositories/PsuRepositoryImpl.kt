package com.example.data.repositories

import com.example.data.dao.PsuDAO
import com.example.data.entities.PSUEntity
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import com.example.domain.enitities.PSU
import com.example.domain.repositories.PsuRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PsuRepositoryImpl(private val psuDAO: PsuDAO) : PsuRepository {
    override fun getPsus(): Flow<List<PSU>> = psuDAO.getPsus().map { it.map(PSUEntity::toDomain) }

    override fun getPsu(id: Int): PSU {
        return psuDAO.getPsu(id).toDomain()
    }

    override fun insertPsu(psu: PSU) {
        psuDAO.insertPsu(psu.toData())
    }

    override fun updatePsu(psu: PSU) {
        psuDAO.updatePsu(psu.toData())
    }

    override fun deletePsu(psu: PSU) {
        psuDAO.deletePsu(psu.toData())
    }
}
