package com.example.domain.usecases

import com.example.domain.enitities.CPU
import com.example.domain.enitities.Cooler
import com.example.domain.enitities.HardDrive
import com.example.domain.enitities.Motherboard
import com.example.domain.enitities.PSU
import com.example.domain.enitities.Pc
import com.example.domain.enitities.PcCase
import com.example.domain.enitities.RAM
import com.example.domain.enitities.VideoCard
import com.example.domain.repositories.PcRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock


class GetBuildUseCaseTest {
    private val pcRepository: PcRepository = mock()
    private val getBuildUseCase: GetBuildUseCase = GetBuildUseCase(pcRepository)

    @Test
    fun `should return ready-made pc`() {
        val id: Int = 1
        val expectedCooler: Cooler =
            Cooler(1, "Cooler", "Price", "HeatSink", "Size", "Socket", "photo")
        val expectedCpu: CPU =
            CPU(1, "CPU", "Price", "Socket", "ClockRate", "Wattage", "Photo")
        val expectedHardDrive: HardDrive =
            HardDrive(1, "Name", "Price", 0, "Type", "Size", 0, "Photo")
        val expectedMotherboard =
            Motherboard(1, "Motherboard", "Price", "Size", "Socket", "Photo")
        val expectedPcCase =
            PcCase(1, "Name", "Price", "Size", "Photo")
        val expectedPsu =
            PSU(1, "Name", "Price", "Wattage", "PinCPU", "PinPCIE", "Photo")
        val expectedRam =
            RAM(1, "Name", "Price", "ClockRate", "Type", "Photo")
        val expectedVideoCard =
            VideoCard(1, "Name", "Price", "Size", "ClockRate", "Wattage", "VideoMemory", "TypeVideoMemory", "Photo")
        val expected: Pc = Pc(
            id = 1,
            name = "Pc Name",
            price = "30000",
            cooler = expectedCooler,
            cpu = expectedCpu,
            hardDrive = expectedHardDrive,
            motherboard = expectedMotherboard,
            pcCase = expectedPcCase,
            psu = expectedPsu,
            ram = expectedRam,
            videoCard = expectedVideoCard,
        )

        val actualCooler: Cooler =
            Cooler(1, "Cooler", "Price", "HeatSink", "Size", "Socket", "photo")
        val actualCpu: CPU =
            CPU(1, "CPU", "Price", "Socket", "ClockRate", "Wattage", "Photo")
        val actualHardDrive: HardDrive =
            HardDrive(1, "Name", "Price", 0, "Type", "Size", 0, "Photo")
        val actualMotherboard =
            Motherboard(1, "Motherboard", "Price", "Size", "Socket", "Photo")
        val actualPcCase =
            PcCase(1, "Name", "Price", "Size", "Photo")
        val actualPsu =
            PSU(1, "Name", "Price", "Wattage", "PinCPU", "PinPCIE", "Photo")
        val actualRam =
            RAM(1, "Name", "Price", "ClockRate", "Type", "Photo")
        val actualVideoCard =
            VideoCard(1, "Name", "Price", "Size", "ClockRate", "Wattage", "VideoMemory", "TypeVideoMemory", "Photo")
        val actual: Pc = Pc(
            id = 1,
            name = "Pc Name",
            price = "30000",
            cooler = actualCooler,
            cpu = actualCpu,
            hardDrive = actualHardDrive,
            motherboard = actualMotherboard,
            pcCase = actualPcCase,
            psu = actualPsu,
            ram = actualRam,
            videoCard = actualVideoCard,
        )

        Mockito.`when`(pcRepository.getPc(id)).thenReturn(expected)

        assertEquals(getBuildUseCase.execute(id), actual)
    }
}