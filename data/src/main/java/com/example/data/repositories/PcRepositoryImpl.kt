package com.example.data.repositories

import com.example.data.dao.PcDAO
import com.example.data.entities.PcWithData
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import com.example.domain.entities.Pc
import com.example.domain.repositories.PcRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PcRepositoryImpl @Inject constructor(private val pcDAO: PcDAO) : PcRepository {
    override fun getPc(): Flow<List<Pc>> =
        pcDAO.getPc().map { it.map(PcWithData::toDomain) }

    override fun getPc(id: Int): Pc =
        pcDAO.getPc(id).toDomain()

    override fun insertPc(pc: Pc) {
        pcDAO.insertPc(pc.toData())
    }

    override fun updatePc(pc: Pc) {
        pcDAO.updatePc(pc.toData())
    }

    override fun deletePc(pc: Pc) {
        pcDAO.deletePc(pc.toData())
    }
}
