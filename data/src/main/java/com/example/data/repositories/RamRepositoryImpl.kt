package com.example.data.repositories

import com.example.data.dao.RamDAO
import com.example.data.entities.RAMEntity
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import com.example.domain.enitities.RAM
import com.example.domain.repositories.RamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RamRepositoryImpl(private val ramDAO: RamDAO) : RamRepository {
    override fun getRams(): Flow<List<RAM>> = ramDAO.getRams().map { it.map(RAMEntity::toDomain) }

    override fun getRam(id: Int): RAM {
        return ramDAO.getRam(id).toDomain()
    }

    override fun insertRam(ram: RAM) {
        ramDAO.insertRam(ram.toData())
    }

    override fun updateRam(ram: RAM) {
        ramDAO.updateRam(ram.toData())
    }

    override fun deleteRam(ram: RAM) {
        ramDAO.deleteRam(ram.toData())
    }
}
