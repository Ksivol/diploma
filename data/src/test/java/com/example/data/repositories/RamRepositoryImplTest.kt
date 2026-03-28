package com.example.data.repositories

import com.example.data.dao.RamDAO
import com.example.data.entities.RAMEntity
import com.example.domain.entities.RAM
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class RamRepositoryImplTest {
    private val ramDAO: RamDAO = Mockito.mock()
    private val ramRepository: RamRepositoryImpl = RamRepositoryImpl(ramDAO)

    @Test
    fun `should return list of ram`() = runBlocking{
        val ramEntity1: RAMEntity = RAMEntity(1, "Name", "Price", "ClockRate", "Type", "Photo")
        val ramEntity2: RAMEntity = RAMEntity(2, "Name", "Price", "ClockRate", "Type", "Photo")
        val ramEntity3: RAMEntity = RAMEntity(3, "Name", "Price", "ClockRate", "Type", "Photo")
        val listOfRamEntity: List<RAMEntity> = listOf(ramEntity1, ramEntity2, ramEntity3)

        val ram1: RAM = RAM(1, "Name", "Price", "ClockRate", "Type", "Photo")
        val ram2: RAM = RAM(2, "Name", "Price", "ClockRate", "Type", "Photo")
        val ram3: RAM = RAM(3, "Name", "Price", "ClockRate", "Type", "Photo")
        val expected: List<RAM> = listOf(ram1, ram2, ram3)

        Mockito.`when`(ramDAO.getRams()).thenReturn(flowOf(listOfRamEntity))

        val actual: List<RAM> = ramRepository.getRams().last()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return ram by id`() {
        val id: Int = 1
        val ramEntity: RAMEntity = RAMEntity(1, "Name", "Price", "ClockRate", "Type", "Photo")
        val expected: RAM = RAM(1, "Name", "Price", "ClockRate", "Type", "Photo")

        Mockito.`when`(ramDAO.getRam(id)).thenReturn(ramEntity)

        val actual: RAM = ramRepository.getRam(id)

        assertEquals(expected, actual)
    }
}