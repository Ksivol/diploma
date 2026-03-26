package com.example.data.repositories

import com.example.data.dao.MotherboardDAO
import com.example.data.entities.MotherboardEntity
import com.example.domain.entities.Motherboard
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class MotherboardRepositoryImplTest {
    private val motherboardDAO: MotherboardDAO = Mockito.mock()
    private val motherboardRepository: MotherboardRepositoryImpl = MotherboardRepositoryImpl(motherboardDAO)

    @Test
    fun `should return list of motherboards`() = runBlocking {
        val motherboardEntity1: MotherboardEntity =
            MotherboardEntity(1, "Name", "Price", "Size", "Socket", "Photo")
        val motherboardEntity2: MotherboardEntity =
            MotherboardEntity(1, "Name", "Price", "Size", "Socket", "Photo")
        val motherboardEntity3: MotherboardEntity =
            MotherboardEntity(1, "Name", "Price", "Size", "Socket", "Photo")
        val listOfMotherboardEntity: List<MotherboardEntity> =
            listOf(motherboardEntity1, motherboardEntity2, motherboardEntity3)

        val motherboard1: Motherboard =
            Motherboard(1, "Name", "Price", "Size", "Socket", "Photo")
        val motherboard2: Motherboard =
            Motherboard(1, "Name", "Price", "Size", "Socket", "Photo")
        val motherboard3: Motherboard =
            Motherboard(1, "Name", "Price", "Size", "Socket", "Photo")
        val expected: List<Motherboard> = listOf(motherboard1, motherboard2, motherboard3)

        Mockito.`when`(motherboardDAO.getMotherboards()).thenReturn(flowOf(listOfMotherboardEntity))
        val actual: List<Motherboard> = motherboardRepository.getMotherboards().last()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return motherboard by id`() {
        val id: Int = 1
        val motherboardEntity1: MotherboardEntity =
            MotherboardEntity(1, "Name", "Price", "Size", "Socket", "Photo")

        val expected: Motherboard =
            Motherboard(1, "Name", "Price", "Size", "Socket", "Photo")

        Mockito.`when`(motherboardDAO.getMotherboard(id)).thenReturn(motherboardEntity1)
        val actual: Motherboard = motherboardRepository.getMotherboard(id)

        assertEquals(expected, actual)
    }
}