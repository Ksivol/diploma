package com.example.data.repositories

import com.example.data.dao.CoolerDAO
import com.example.data.entities.CoolerEntity
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import com.example.domain.enitities.Cooler
import com.example.domain.repositories.CoolerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CoolerRepositoryImpl(private val coolerDAO: CoolerDAO) : CoolerRepository {
    override fun getCoolers(): Flow<List<Cooler>> = coolerDAO.getCoolers().map { it.map(CoolerEntity::toDomain) }

    override fun insertCooler(cooler: Cooler) {
        coolerDAO.insertCooler(cooler.toData())
    }

    override fun updateCooler(cooler: Cooler) {
        coolerDAO.updateCooler(cooler.toData())
    }

    override fun deleteCooler(cooler: Cooler) {
        coolerDAO.deleteCooler(cooler.toData())
    }
}
