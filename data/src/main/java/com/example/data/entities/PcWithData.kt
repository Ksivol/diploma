package com.example.data.entities

import androidx.room.Embedded

data class PcWithData(
    val id: Int,
    val name: String,
    val price: String,
    @Embedded("cpu_") val cpu: CPUEntity,
    @Embedded("clr_") val cooler: CoolerEntity,
    @Embedded("hd_") val hardDrive: HardDriveEntity,
    @Embedded("mthb_") val motherboard: MotherboardEntity,
    @Embedded("pcc_") val pcCase: PcCaseEntity,
    @Embedded("psu_") val psu: PSUEntity,
    @Embedded("ram_") val ram: RAMEntity,
    @Embedded("vdcrd_") val videoCard: VideoCardEntity
)
