package com.example.data.repositories

import com.example.data.dao.CoolerDAO
import com.example.data.dao.CpuDAO
import com.example.data.dao.HardDriveDAO
import com.example.data.dao.MotherboardDAO
import com.example.data.dao.PcCaseDAO
import com.example.data.dao.PcDAO
import com.example.data.dao.PsuDAO
import com.example.data.dao.RamDAO
import com.example.data.dao.VideoCardDAO
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import com.example.domain.enitities.Pc
import com.example.domain.repositories.PcRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PcRepositoryImpl
    @Inject
    constructor(
        private val pcDAO: PcDAO,
        private val coolerDAO: CoolerDAO,
        private val cpuDAO: CpuDAO,
        private val hardDriveDAO: HardDriveDAO,
        private val motherboardDAO: MotherboardDAO,
        private val pcCaseDAO: PcCaseDAO,
        private val psuDAO: PsuDAO,
        private val ramDAO: RamDAO,
        private val videoCardDAO: VideoCardDAO,
    ) : PcRepository {
        override fun getPc(): Flow<List<Pc>> =
            pcDAO.getPc().map { list ->
                list.map {
                    it.toDomain(
                        coolerDAO.getCooler(it.id).toDomain(),
                        cpuDAO.getCpu(it.id).toDomain(),
                        hardDriveDAO.getHardDrive(it.id).toDomain(),
                        motherboardDAO.getMotherboard(it.id).toDomain(),
                        pcCaseDAO.getPcCase(it.id).toDomain(),
                        psuDAO.getPsu(it.id).toDomain(),
                        ramDAO.getRam(it.id).toDomain(),
                        videoCardDAO.getVideoCard(it.id).toDomain(),
                    )
                }
            }

        override fun getPc(id: Int): Pc =
            pcDAO.getPc(id).toDomain(
                coolerDAO.getCooler(id).toDomain(),
                cpuDAO.getCpu(id).toDomain(),
                hardDriveDAO.getHardDrive(id).toDomain(),
                motherboardDAO.getMotherboard(id).toDomain(),
                pcCaseDAO.getPcCase(id).toDomain(),
                psuDAO.getPsu(id).toDomain(),
                ramDAO.getRam(id).toDomain(),
                videoCardDAO.getVideoCard(id).toDomain(),
            )

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
