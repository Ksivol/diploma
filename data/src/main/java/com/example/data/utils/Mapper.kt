package com.example.data.utils

import com.example.data.entities.CPUEntity
import com.example.data.entities.CoolerEntity
import com.example.data.entities.HardDriveEntity
import com.example.data.entities.MotherboardEntity
import com.example.data.entities.PSUEntity
import com.example.data.entities.PcCaseEntity
import com.example.data.entities.PcEntity
import com.example.data.entities.PcWithData
import com.example.data.entities.RAMEntity
import com.example.data.entities.VideoCardEntity
import com.example.domain.entities.CPU
import com.example.domain.entities.Cooler
import com.example.domain.entities.HardDrive
import com.example.domain.entities.Motherboard
import com.example.domain.entities.PSU
import com.example.domain.entities.Pc
import com.example.domain.entities.PcCase
import com.example.domain.entities.RAM
import com.example.domain.entities.VideoCard
import java.math.BigDecimal

/**
 * Маппит [CoolerEntity] (моделька из Data слоя) к [Cooler] (моделька из Domain слоя)
 * @return [Cooler]
 */
fun CoolerEntity.toDomain(): Cooler {
    return Cooler(id, name, price.bigDecimal, heatSink, size, socket, favorite == 1, photo)
}

/**
 * Маппит [Cooler] (моделька из Domain слоя) к [CoolerEntity] (моделька из Data слоя)
 * @return [CoolerEntity]
 */
fun Cooler.toData(): CoolerEntity {
    return CoolerEntity(
        id,
        name,
        price.string,
        heatSink,
        size,
        socket,
        if (favorite) 1 else 0,
        photo
    )
}

/**
 * Маппит [CPUEntity] (моделька из Data слоя) к [CPU] (моделька из Domain слоя)
 * @return [CPU]
 */
fun CPUEntity.toDomain(): CPU {
    return CPU(id, name, price.bigDecimal, socket, clockRate, wattage, favorite == 1, photo)
}

/**
 * Маппит [CPU] (моделька из Domain слоя) к [CPUEntity] (моделька из Data слоя)
 * @return [CPUEntity]
 */
fun CPU.toData(): CPUEntity {
    return CPUEntity(
        id,
        name,
        price.string,
        socket,
        clockRate,
        wattage,
        if (favorite) 1 else 0,
        photo
    )
}

/**
 * Маппит [HardDriveEntity] (моделька из Data слоя) к [HardDrive] (моделька из Domain слоя)
 * @return [HardDrive]
 */
fun HardDriveEntity.toDomain(): HardDrive {
    return HardDrive(id, name, price.bigDecimal, capacity, type, overwrite, favorite == 1, photo)
}

/**
 * Маппит [HardDrive] (моделька из Domain слоя) к [HardDriveEntity] (моделька из Data слоя)
 * @return [HardDriveEntity]
 */
fun HardDrive.toData(): HardDriveEntity {
    return HardDriveEntity(
        id,
        name,
        price.string,
        capacity,
        type,
        overwrite,
        if (favorite) 1 else 0,
        photo
    )
}

/**
 * Маппит [MotherboardEntity] (моделька из Data слоя) к [Motherboard] (моделька из Domain слоя)
 * @return [Motherboard]
 */
fun MotherboardEntity.toDomain(): Motherboard {
    return Motherboard(id, name, price.bigDecimal, size, socket, favorite == 1, photo)
}

/**
 * Маппит [Motherboard] (моделька из Domain слоя) к [MotherboardEntity] (моделька из Data слоя)
 * @return [MotherboardEntity]
 */
fun Motherboard.toData(): MotherboardEntity {
    return MotherboardEntity(id, name, price.string, size, socket, if (favorite) 1 else 0, photo)
}

/**
 * Маппит [PcCaseEntity] (моделька из Data слоя) к [PcCase] (моделька из Domain слоя)
 * @return [PcCase]
 */
fun PcCaseEntity.toDomain(): PcCase {
    return PcCase(id, name, price.bigDecimal, size, favorite == 1, photo)
}

/**
 * Маппит [PcCase] (моделька из Domain слоя) к [PcCaseEntity] (моделька из Data слоя)
 * @return [PcCaseEntity]
 */
fun PcCase.toData(): PcCaseEntity {
    return PcCaseEntity(id, name, price.string, size, if (favorite) 1 else 0, photo)
}

/**
 * Маппит [PSUEntity] (моделька из Data слоя) к [PSU] (моделька из Domain слоя)
 * @return [PSU]
 */
fun PSUEntity.toDomain(): PSU {
    return PSU(id, name, price.bigDecimal, wattage, pinCPU, pinPCIE, favorite == 1, photo)
}

/**
 * Маппит [PSU] (моделька из Domain слоя) к [PSUEntity] (моделька из Data слоя)
 * @return [PSUEntity]
 */
fun PSU.toData(): PSUEntity {
    return PSUEntity(
        id,
        name,
        price.string,
        wattage,
        pinCPU,
        pinPCIE,
        if (favorite) 1 else 0,
        photo
    )
}

/**
 * Маппит [RAMEntity] (моделька из Data слоя) к [RAM] (моделька из Domain слоя)
 * @return [RAM]
 */
fun RAMEntity.toDomain(): RAM {
    return RAM(id, name, price.bigDecimal, clockRate, type, quantity, favorite == 1, photo)
}

/**
 * Маппит [RAM] (моделька из Domain слоя) к [RAMEntity] (моделька из Data слоя)
 * @return [RAMEntity]
 */
fun RAM.toData(): RAMEntity {
    return RAMEntity(
        id,
        name,
        price.string,
        clockRate,
        type,
        quantity,
        if (favorite) 1 else 0,
        photo
    )
}

/**
 * Маппит [VideoCardEntity] (моделька из Data слоя) к [VideoCard] (моделька из Domain слоя)
 * @return [VideoCard]
 */
fun VideoCardEntity.toDomain(): VideoCard {
    return VideoCard(
        id,
        name,
        price.bigDecimal,
        clockRate,
        size,
        wattage,
        videoMemory,
        typeVideoMemory,
        favorite == 1,
        photo
    )
}

/**
 * Маппит [VideoCard] (моделька из Domain слоя) к [VideoCardEntity] (моделька из Data слоя)
 * @return [VideoCardEntity]
 */
fun VideoCard.toData(): VideoCardEntity {
    return VideoCardEntity(
        id,
        name,
        price.string,
        clockRate,
        size,
        wattage,
        videoMemory,
        typeVideoMemory,
        if (favorite) 1 else 0,
        photo
    )
}

/**
 * Маппит [PcEntity] (моделька из Data слоя) к [Pc] (моделька из Domain слоя)
 * @return [Pc]
 */
fun PcWithData.toDomain(
): Pc {
    return Pc(id, name, price.bigDecimal)
}

/**
 * Маппит [Pc] (моделька из Domain слоя) к [PcEntity] (моделька из Data слоя)
 * @return [PcEntity]
 */
fun Pc.toData(): PcEntity {
    return PcEntity(
        id,
        name,
        price.string,
    )
}

val String.bigDecimal: BigDecimal
    get() = try {
        BigDecimal(this)
    } catch (e: Exception) {
        BigDecimal.ZERO
    }

val BigDecimal.string: String
    get() = this.toString()
