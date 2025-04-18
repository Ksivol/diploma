package com.example.data.repositories

import com.example.data.dao.PcDAO
import com.example.data.entities.CPUEntity
import com.example.data.entities.CoolerEntity
import com.example.data.entities.HardDriveEntity
import com.example.data.entities.MotherboardEntity
import com.example.data.entities.PSUEntity
import com.example.data.entities.PcCaseEntity
import com.example.data.entities.PcWithData
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
import com.example.domain.repositories.PcRepository
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class PcRepositoryImplTest {
    private val pcDao: PcDAO = Mockito.mock()
    private val pcRepository: PcRepository = PcRepositoryImpl(pcDao)

    @Test
    fun `should return list of pc`() = runBlocking {
        val pcWithData1 =
            PcWithData(
                1,
                "Pc",
                "Price",
                CPUEntity(1, "Name", "Price", "Socket", "ClockRate", "Wattage", "Photo"),
                CoolerEntity(1, "Name1", "Price1", "HeatSink1", "Size1", "Socket1", "Photo1"),
                HardDriveEntity(1, "Name", "Price", 0, "Type", "Size", 0, "Photo"),
                MotherboardEntity(1, "Name", "Price", "Size", "Socket", "Photo"),
                PcCaseEntity(1, "Name", "Price", "Size", "Photo"),
                PSUEntity(1, "Name", "Price", "Wattage", "PinPSU", "PinPCIE", "Photo"),
                RAMEntity(1, "Name", "Price", "ClockRate", "Type", "Photo"),
                VideoCardEntity(
                    2,
                    "Name",
                    "Price",
                    "Size",
                    "ClockRate",
                    "Wattage",
                    "VideoMemory",
                    "TypeVideoMemory",
                    "Photo"
                )
            )
        val pcWithData2 =
            PcWithData(
                2,
                "Pc",
                "Price",
                CPUEntity(2, "Name", "Price", "Socket", "ClockRate", "Wattage", "Photo"),
                CoolerEntity(2, "Name2", "Price2", "HeatSink2", "Size2", "Socket2", "Photo2"),
                HardDriveEntity(2, "Name", "Price", 0, "Type", "Size", 0, "Photo"),
                MotherboardEntity(2, "Name", "Price", "Size", "Socket", "Photo"),
                PcCaseEntity(2, "Name", "Price", "Size", "Photo"),
                PSUEntity(2, "Name", "Price", "Wattage", "PinPSU", "PinPCIE", "Photo"),
                RAMEntity(2, "Name", "Price", "ClockRate", "Type", "Photo"),
                VideoCardEntity(
                    2,
                    "Name",
                    "Price",
                    "Size",
                    "ClockRate",
                    "Wattage",
                    "VideoMemory",
                    "TypeVideoMemory",
                    "Photo"
                )
            )
        val pcWithDataList: List<PcWithData> = listOf(pcWithData1, pcWithData2)

        val pc1 =
            Pc(
                1,
                "Pc",
                "Price",
                Cooler(1, "Name1", "Price1", "HeatSink1", "Size1", "Socket1", "Photo1"),
                CPU(1, "Name", "Price", "Socket", "ClockRate", "Wattage", "Photo"),
                HardDrive(1, "Name", "Price", 0, "Type", "Size", 0, "Photo"),
                Motherboard(1, "Name", "Price", "Size", "Socket", "Photo"),
                PcCase(1, "Name", "Price", "Size", "Photo"),
                PSU(1, "Name", "Price", "Wattage", "PinPSU", "PinPCIE", "Photo"),
                RAM(1, "Name", "Price", "ClockRate", "Type", "Photo"),
                VideoCard(2, "Name", "Price", "Size", "ClockRate", "Wattage", "VideoMemory", "TypeVideoMemory", "Photo")
            )
        val pc2 =
            Pc(
                2,
                "Pc",
                "Price",
                Cooler(2, "Name2", "Price2", "HeatSink2", "Size2", "Socket2", "Photo2"),
                CPU(2, "Name", "Price", "Socket", "ClockRate", "Wattage", "Photo"),
                HardDrive(2, "Name", "Price", 0, "Type", "Size", 0, "Photo"),
                Motherboard(2, "Name", "Price", "Size", "Socket", "Photo"),
                PcCase(2, "Name", "Price", "Size", "Photo"),
                PSU(2, "Name", "Price", "Wattage", "PinPSU", "PinPCIE", "Photo"),
                RAM(2, "Name", "Price", "ClockRate", "Type", "Photo"),
                VideoCard(2, "Name", "Price", "Size", "ClockRate", "Wattage", "VideoMemory", "TypeVideoMemory", "Photo")
            )

        val expected: List<Pc> = listOf(pc1, pc2)

        Mockito.`when`(pcDao.getPc()).thenReturn(flowOf(pcWithDataList))
        val actual = pcRepository.getPc().last()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return pc`() {
        val id: Int = 1
        val pcWithData1 =
            PcWithData(
                1,
                "Pc",
                "Price",
                CPUEntity(1, "Name", "Price", "Socket", "ClockRate", "Wattage", "Photo"),
                CoolerEntity(1, "Name1", "Price1", "HeatSink1", "Size1", "Socket1", "Photo1"),
                HardDriveEntity(1, "Name", "Price", 0, "Type", "Size", 0, "Photo"),
                MotherboardEntity(1, "Name", "Price", "Size", "Socket", "Photo"),
                PcCaseEntity(1, "Name", "Price", "Size", "Photo"),
                PSUEntity(1, "Name", "Price", "Wattage", "PinPSU", "PinPCIE", "Photo"),
                RAMEntity(1, "Name", "Price", "ClockRate", "Type", "Photo"),
                VideoCardEntity(
                    2,
                    "Name",
                    "Price",
                    "Size",
                    "ClockRate",
                    "Wattage",
                    "VideoMemory",
                    "TypeVideoMemory",
                    "Photo"
                )
            )

        val expected =
            Pc(
                1,
                "Pc",
                "Price",
                Cooler(1, "Name1", "Price1", "HeatSink1", "Size1", "Socket1", "Photo1"),
                CPU(1, "Name", "Price", "Socket", "ClockRate", "Wattage", "Photo"),
                HardDrive(1, "Name", "Price", 0, "Type", "Size", 0, "Photo"),
                Motherboard(1, "Name", "Price", "Size", "Socket", "Photo"),
                PcCase(1, "Name", "Price", "Size", "Photo"),
                PSU(1, "Name", "Price", "Wattage", "PinPSU", "PinPCIE", "Photo"),
                RAM(1, "Name", "Price", "ClockRate", "Type", "Photo"),
                VideoCard(2, "Name", "Price", "Size", "ClockRate", "Wattage", "VideoMemory", "TypeVideoMemory", "Photo")
            )

        Mockito.`when`(pcDao.getPc(id)).thenReturn(pcWithData1)
        val actual = pcRepository.getPc(id)

        assertEquals(expected, actual)
    }
}