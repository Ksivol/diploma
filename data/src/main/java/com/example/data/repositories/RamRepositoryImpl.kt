package com.example.data.repositories

import com.example.data.dao.RamDAO
import com.example.data.entities.RAMEntity
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import com.example.domain.entities.RAM
import com.example.domain.repositories.RamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RamRepositoryImpl @Inject constructor(private val ramDAO: RamDAO) : RamRepository {
    override fun getRams(): Flow<List<RAM>> =
        ramDAO.getRams().map { it.map(RAMEntity::toDomain) }

    override suspend fun getRam(id: Int): RAM =
        ramDAO.getRam(id).toDomain()

    override suspend fun updateRam(ram: RAM) {
        ramDAO.updateRam(ram.toData())
    }

    override suspend fun toggleFavorite(item: RAM) {
        ramDAO.updateRam(item.toData())
    }
}
