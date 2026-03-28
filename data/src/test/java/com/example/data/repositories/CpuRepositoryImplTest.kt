package com.example.data.repositories

import com.example.data.dao.CpuDAO
import com.example.data.entities.CPUEntity
import com.example.domain.entities.CPU
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class CpuRepositoryImplTest {
    private val cpuDAO: CpuDAO = Mockito.mock()
    private val cpuRepositoryImpl: CpuRepositoryImpl = CpuRepositoryImpl(cpuDAO)

    @Test
    fun `should return list of CPU`() = runBlocking {
        val cpuEntity1: CPUEntity =
            CPUEntity(1, "Name", "Price", "Socket", "ClockRate", "Wattage", "Photo")
        val cpuEntity2: CPUEntity =
            CPUEntity(2, "Name", "Price", "Socket", "ClockRate", "Wattage", "Photo")
        val cpuEntity3: CPUEntity =
            CPUEntity(3, "Name", "Price", "Socket", "ClockRate", "Wattage", "Photo")
        val listOfCPUEntity: List<CPUEntity> = listOf(cpuEntity1, cpuEntity2, cpuEntity3)

        Mockito.`when`(cpuDAO.getCpus()).thenReturn(flowOf(listOfCPUEntity))

        val cpu1: CPU =
            CPU(1, "Name", "Price", "Socket", "ClockRate", "Wattage", "Photo")
        val cpu2: CPU =
            CPU(2, "Name", "Price", "Socket", "ClockRate", "Wattage", "Photo")
        val cpu3: CPU =
            CPU(3, "Name", "Price", "Socket", "ClockRate", "Wattage", "Photo")

        val expected: List<CPU> = listOf(cpu1, cpu2, cpu3)

        val actual: List<CPU> = cpuRepositoryImpl.getCpus().last()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return CPU by id`() {
        val id: Int = 1
        val cpu: CPUEntity =
            CPUEntity(1, "Name", "Price", "Socket", "ClockRate", "Wattage", "Photo")
        val expected: CPU =
            CPU(1, "Name", "Price", "Socket", "ClockRate", "Wattage", "Photo")

        Mockito.`when`(cpuDAO.getCpu(id)).thenReturn(cpu)
        val actual: CPU = cpuRepositoryImpl.getCpu(id)

        assertEquals(expected, actual)
    }
}