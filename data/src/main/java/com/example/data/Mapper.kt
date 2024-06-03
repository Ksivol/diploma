package com.example.data

typealias DataCooler = com.example.data.entities.Cooler
typealias DomainCooler = com.example.domain.enitities.Cooler
typealias DataCpu = com.example.data.entities.CPU
typealias DomainCpu = com.example.domain.enitities.CPU
typealias DataHardDrive = com.example.data.entities.HardDrive
typealias DomainHardDrive = com.example.domain.enitities.HardDrive
typealias DataMotherboard = com.example.data.entities.Motherboard
typealias DomainMotherboard = com.example.domain.enitities.Motherboard
typealias DataPcCase = com.example.data.entities.PcCase
typealias DomainPcCase = com.example.domain.enitities.PcCase
typealias DataPSU = com.example.data.entities.PSU
typealias DomainPSU = com.example.domain.enitities.PSU
typealias DataRAM = com.example.data.entities.RAM
typealias DomainRAM = com.example.domain.enitities.RAM
typealias DataVideoCard = com.example.data.entities.VideoCard
typealias DomainVideoCard = com.example.domain.enitities.VideoCard

/**
 * Маппит [DataCooler] (моделька из Data слоя) к [DomainCooler] (моделька из Domain слоя)
 * @return [DomainCooler]
 */
fun DataCooler.toDomain(): DomainCooler {
    return DomainCooler(id, name, price, heatSink)
}

/**
 * Маппит [DomainCooler] (моделька из Domain слоя) к [DataCooler] (моделька из Data слоя)
 * @return [DataCooler]
 */
fun DomainCooler.toData(): DataCooler {
    return DataCooler(id, name, price, heatSink)
}

/**
 * Маппит [DataCpu] (моделька из Data слоя) к [DomainCpu] (моделька из Domain слоя)
 * @return [DataCpu]
 */
fun DataCpu.toDomain(): DomainCpu {
    return DomainCpu(id, name, price, socket, clockRate, wattage)
}

/**
 * Маппит [DomainCpu] (моделька из Domain слоя) к [DataCpu] (моделька из Data слоя)
 * @return [DataCpu]
 */
fun DomainCpu.toData(): DataCpu {
    return DataCpu(id, name, price, socket, clockRate, wattage)
}

/**
 * Маппит [DataHardDrive] (моделька из Data слоя) к [DomainHardDrive] (моделька из Domain слоя)
 * @return [DomainHardDrive]
 */
fun DataHardDrive.toDomain(): DomainHardDrive {
    return DomainHardDrive(id, name, price, capacity, type, size, overwrite)
}

/**
 * Маппит [DomainHardDrive] (моделька из Domain слоя) к [DataHardDrive] (моделька из Data слоя)
 * @return [DataHardDrive]
 */
fun DomainHardDrive.toData(): DataHardDrive {
    return DataHardDrive(id, name, price, capacity, type, size, overwrite)
}

/**
 * Маппит [DataMotherboard] (моделька из Data слоя) к [DomainMotherboard] (моделька из Domain слоя)
 * @return [DomainMotherboard]
 */
fun DataMotherboard.toDomain(): DomainMotherboard {
    return DomainMotherboard(id, name, price, size, socket)
}

/**
 * Маппит [DomainMotherboard] (моделька из Domain слоя) к [DataMotherboard] (моделька из Data слоя)
 * @return [DataMotherboard]
 */
fun DomainMotherboard.toData(): DataMotherboard {
    return DataMotherboard(id, name, price, size, socket)
}

/**
 * Маппит [DataPcCase] (моделька из Data слоя) к [DomainPcCase] (моделька из Domain слоя)
 * @return [DomainPcCase]
 */
fun DataPcCase.toDomain(): DomainPcCase {
    return DomainPcCase(id, name, price, size)
}

/**
 * Маппит [DomainPcCase] (моделька из Domain слоя) к [DataPcCase] (моделька из Data слоя)
 * @return [DataPcCase]
 */
fun DomainPcCase.toData(): DataPcCase {
    return DataPcCase(id, name, price, size)
}

/**
 * Маппит [DataPSU] (моделька из Data слоя) к [DomainPSU] (моделька из Domain слоя)
 * @return [DomainPSU]
 */
fun DataPSU.toDomain(): DomainPSU {
    return DomainPSU(id, name, price, wattage, lines)
}

/**
 * Маппит [DomainPSU] (моделька из Domain слоя) к [DataPSU] (моделька из Data слоя)
 * @return [DataPSU]
 */
fun DomainPSU.toData(): DataPSU {
    return DataPSU(id, name, price, wattage, lines)
}

/**
 * Маппит [DataRAM] (моделька из Data слоя) к [DomainRAM] (моделька из Domain слоя)
 * @return [DomainRAM]
 */
fun DataRAM.toDomain(): DomainRAM {
    return DomainRAM(id, name, price, clockRate, type)
}

/**
 * Маппит [DomainRAM] (моделька из Domain слоя) к [DataRAM] (моделька из Data слоя)
 * @return [DataRAM]
 */
fun DomainRAM.toData(): DataRAM {
    return DataRAM(id, name, price, clockRate, type)
}

/**
 * Маппит [DataVideoCard] (моделька из Data слоя) к [DomainVideoCard] (моделька из Domain слоя)
 * @return [DomainVideoCard]
 */
fun DataVideoCard.toDomain(): DomainVideoCard {
    return DomainVideoCard(id, name, price, size, clockRate, wattage, videoMemory)
}

/**
 * Маппит [DomainVideoCard] (моделька из Domain слоя) к [DataVideoCard] (моделька из Data слоя)
 * @return [DataVideoCard]
 */
fun DomainVideoCard.toData() : DataVideoCard {
    return DataVideoCard(id, name, price, size, clockRate, wattage, videoMemory)
}