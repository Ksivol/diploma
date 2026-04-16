package com.example.data.repositories

import com.example.data.dao.CoolerDAO
import com.example.data.entities.CoolerEntity
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import com.example.domain.entities.Cooler
import com.example.domain.repositories.CoolerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CoolerRepositoryImpl @Inject constructor(private val coolerDAO: CoolerDAO) : CoolerRepository {
    override fun getCoolers(): Flow<List<Cooler>> =
        coolerDAO.getCoolers().map { it.map(CoolerEntity::toDomain) }

    override suspend fun getCooler(id: Int): Cooler =
        coolerDAO.getCooler(id).toDomain()

    override suspend fun updateCooler(cooler: Cooler) {
        coolerDAO.updateCooler(cooler.toData())
    }

    override suspend fun toggleFavorite(item: Cooler) {
        coolerDAO.updateCooler(item.toData())
    }
}
