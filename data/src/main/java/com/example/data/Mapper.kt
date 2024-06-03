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

fun DataCooler.toDomain(): DomainCooler {
    return DomainCooler(id, name, price, heatSink)
}

fun DomainCooler.toData(): DataCooler {
    return DataCooler(id, name, price, heatSink)
}

fun DataCpu.toDomain(): DomainCpu {
    return DomainCpu(id, name, price, socket, clockRate, wattage)
}

fun DomainCpu.toData(): DataCpu {
    return DataCpu(id, name, price, socket, clockRate, wattage)
}

fun DataHardDrive.toDomain(): DomainHardDrive {
    return DomainHardDrive(id, name, price, capacity, type, size, overwrite)
}

fun DomainHardDrive.toData(): DataHardDrive {
    return DataHardDrive(id, name, price, capacity, type, size, overwrite)
}

fun DataMotherboard.toDomain(): DomainMotherboard {
    return DomainMotherboard(id, name, price, size, socket)
}

fun DomainMotherboard.toData(): DataMotherboard {
    return DataMotherboard(id, name, price, size, socket)
}

fun DataPcCase.toDomain(): DomainPcCase {
    return DomainPcCase(id, name, price, size)
}

fun DomainPcCase.toData(): DataPcCase {
    return DataPcCase(id, name, price, size)
}

fun DataPSU.toDomain(): DomainPSU {
    return DomainPSU(id, name, price, wattage, lines)
}

fun DomainPSU.toData(): DataPSU {
    return DataPSU(id, name, price, wattage, lines)
}

fun DataRAM.toDomain(): DomainRAM {
    return DomainRAM(id, name, price, clockRate, type)
}

fun DomainRAM.toData(): DataRAM {
    return DataRAM(id, name, price, clockRate, type)
}

fun DataVideoCard.toDomain(): DomainVideoCard {
    return DomainVideoCard(id, name, price, size, clockRate, wattage, videoMemory)
}

fun DomainVideoCard.toData() : DataVideoCard {
    return DataVideoCard(id, name, price, size, clockRate, wattage, videoMemory)
}