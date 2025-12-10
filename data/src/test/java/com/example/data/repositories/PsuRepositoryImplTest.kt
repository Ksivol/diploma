package com.example.data.repositories

import com.example.data.dao.PsuDAO
import com.example.data.entities.PSUEntity
import com.example.domain.enitities.PSU
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class PsuRepositoryImplTest {
    private val psuDAO: PsuDAO = Mockito.mock()
    private val psuRepository: PsuRepositoryImpl = PsuRepositoryImpl(psuDAO)

    @Test
    fun `should return list of psu`() = runBlocking {
        val psuEntity1: PSUEntity =
            PSUEntity(1, "Name", "Price", "Wattage", "PinPSU", "PinPCIE", "Photo")
        val psuEntity2: PSUEntity =
            PSUEntity(2, "Name", "Price", "Wattage", "PinPSU", "PinPCIE", "Photo")
        val psuEntity3: PSUEntity =
            PSUEntity(3, "Name", "Price", "Wattage", "PinPSU", "PinPCIE", "Photo")
        val listOfPsuEntity: List<PSUEntity> = listOf(psuEntity1, psuEntity2, psuEntity3)

        val psu1: PSU =
            PSU(1, "Name", "Price", "Wattage", "PinPSU", "PinPCIE", "Photo")
        val psu2: PSU =
            PSU(2, "Name", "Price", "Wattage", "PinPSU", "PinPCIE", "Photo")
        val psu3: PSU =
            PSU(3, "Name", "Price", "Wattage", "PinPSU", "PinPCIE", "Photo")
        val expected: List<PSU> = listOf(psu1, psu2, psu3)

        Mockito.`when`(psuDAO.getPsuList()).thenReturn(flowOf(listOfPsuEntity))

        val actual: List<PSU> = psuRepository.getPsuList().last()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return psu by id`() {
        val id: Int = 1
        val psuEntity: PSUEntity =
            PSUEntity(1, "Name", "Price", "Wattage", "PinPSU", "PinPCIE", "Photo")
        val expected: PSU =
            PSU(1, "Name", "Price", "Wattage", "PinPSU", "PinPCIE", "Photo")

        Mockito.`when`(psuDAO.getPsu(id)).thenReturn(psuEntity)

        val actual: PSU = psuRepository.getPsu(id)

        assertEquals(expected, actual)
    }
}