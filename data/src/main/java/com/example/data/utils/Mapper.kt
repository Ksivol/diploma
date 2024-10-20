package com.example.data.utils

import com.example.data.dao.CoolerDAO
import com.example.data.dao.CpuDAO
import com.example.data.dao.HardDriveDAO
import com.example.data.dao.MotherboardDAO
import com.example.data.entities.CPUEntity
import com.example.data.entities.CoolerEntity
import com.example.data.entities.HardDriveEntity
import com.example.data.entities.MotherboardEntity
import com.example.data.entities.PSUEntity
import com.example.data.entities.PcCaseEntity
import com.example.data.entities.PcEntity
import com.example.data.entities.RAMEntity
import com.example.data.entities.VideoCardEntity
import com.example.domain.enitities.CPU
import com.example.domain.enitities.Cooler
import com.example.domain.enitities.HardDrive
import com.example.domain.enitities.Motherboard
import com.example.domain.enitities.PSU
import com.example.domain.enitities.Pc
import com.example.domain.enitities.PcCase
import com.example.domain.enitities.RAM
import com.example.domain.enitities.VideoCard

/**
 * Маппит [CoolerEntity] (моделька из Data слоя) к [Cooler] (моделька из Domain слоя)
 * @return [Cooler]
 */
fun CoolerEntity.toDomain(): Cooler {
    return Cooler(id, name, price, heatSink, size, socket, photo)
}

/**
 * Маппит [Cooler] (моделька из Domain слоя) к [CoolerEntity] (моделька из Data слоя)
 * @return [CoolerEntity]
 */
fun Cooler.toData(): CoolerEntity {
    return CoolerEntity(id, name, price, heatSink, size, socket, photo)
}

/**
 * Маппит [CPUEntity] (моделька из Data слоя) к [CPU] (моделька из Domain слоя)
 * @return [CPUEntity]
 */
fun CPUEntity.toDomain(): CPU {
    return CPU(id, name, price, socket, clockRate, wattage, photo)
}

/**
 * Маппит [CPU] (моделька из Domain слоя) к [CPUEntity] (моделька из Data слоя)
 * @return [CPUEntity]
 */
fun CPU.toData(): CPUEntity {
    return CPUEntity(id, name, price, socket, clockRate, wattage, photo)
}

/**
 * Маппит [HardDriveEntity] (моделька из Data слоя) к [HardDrive] (моделька из Domain слоя)
 * @return [HardDrive]
 */
fun HardDriveEntity.toDomain(): HardDrive {
    return HardDrive(id, name, price, capacity, type, size, overwrite, photo)
}

/**
 * Маппит [HardDrive] (моделька из Domain слоя) к [HardDriveEntity] (моделька из Data слоя)
 * @return [HardDriveEntity]
 */
fun HardDrive.toData(): HardDriveEntity {
    return HardDriveEntity(id, name, price, capacity, type, size, overwrite, photo)
}

/**
 * Маппит [MotherboardEntity] (моделька из Data слоя) к [Motherboard] (моделька из Domain слоя)
 * @return [Motherboard]
 */
fun MotherboardEntity.toDomain(): Motherboard {
    return Motherboard(id, name, price, size, socket, photo)
}

/**
 * Маппит [Motherboard] (моделька из Domain слоя) к [MotherboardEntity] (моделька из Data слоя)
 * @return [MotherboardEntity]
 */
fun Motherboard.toData(): MotherboardEntity {
    return MotherboardEntity(id, name, price, size, socket, photo)
}

/**
 * Маппит [PcCaseEntity] (моделька из Data слоя) к [PcCase] (моделька из Domain слоя)
 * @return [PcCase]
 */
fun PcCaseEntity.toDomain(): PcCase {
    return PcCase(id, name, price, size, photo)
}

/**
 * Маппит [PcCase] (моделька из Domain слоя) к [PcCaseEntity] (моделька из Data слоя)
 * @return [PcCaseEntity]
 */
fun PcCase.toData(): PcCaseEntity {
    return PcCaseEntity(id, name, price, size, photo)
}

/**
 * Маппит [PSUEntity] (моделька из Data слоя) к [PSU] (моделька из Domain слоя)
 * @return [PSU]
 */
fun PSUEntity.toDomain(): PSU {
    return PSU(id, name, price, wattage, pinCPU, pinPCIE, photo)
}

/**
 * Маппит [PSU] (моделька из Domain слоя) к [PSUEntity] (моделька из Data слоя)
 * @return [PSUEntity]
 */
fun PSU.toData(): PSUEntity {
    return PSUEntity(id, name, price, wattage, pinCPU, pinPCIE, photo)
}

/**
 * Маппит [RAMEntity] (моделька из Data слоя) к [RAM] (моделька из Domain слоя)
 * @return [RAM]
 */
fun RAMEntity.toDomain(): RAM {
    return RAM(id, name, price, clockRate, type, photo)
}

/**
 * Маппит [RAM] (моделька из Domain слоя) к [RAMEntity] (моделька из Data слоя)
 * @return [RAMEntity]
 */
fun RAM.toData(): RAMEntity {
    return RAMEntity(id, name, price, clockRate, type, photo)
}

/**
 * Маппит [VideoCardEntity] (моделька из Data слоя) к [VideoCard] (моделька из Domain слоя)
 * @return [VideoCard]
 */
fun VideoCardEntity.toDomain(): VideoCard {
    return VideoCard(id, name, price, size, clockRate, wattage, videoMemory, typeVideoMemory, photo)
}

/**
 * Маппит [VideoCard] (моделька из Domain слоя) к [VideoCardEntity] (моделька из Data слоя)
 * @return [VideoCardEntity]
 */
fun VideoCard.toData(): VideoCardEntity {
    return VideoCardEntity(id, name, price, size, clockRate, wattage, videoMemory, typeVideoMemory, photo)
}

/**
 * Маппит [PcEntity] (моделька из Data слоя) к [Pc] (моделька из Domain слоя)
 * @return [Pc]
 */
fun PcEntity.toDomain(
    cooler: Cooler, cpu: CPU, hardDrive: HardDrive, motherboard: Motherboard,
    pcCase: PcCase, psu: PSU, ram: RAM, videoCard: VideoCard
): Pc {
    return Pc(id, name, price, cooler, cpu, hardDrive, motherboard, pcCase, psu, ram, videoCard)
}

/**
 * Маппит [Pc] (моделька из Domain слоя) к [PcEntity] (моделька из Data слоя)
 * @return [PcEntity]
 */
fun Pc.toData(): PcEntity {
    return PcEntity(
        id,
        name,
        price,
        cooler.id,
        cpu.id,
        hardDrive.id,
        motherboard.id,
        pcCase.id,
        psu.id,
        ram.id,
        videoCard.id
    )
}
