package com.example.data.repositories

import com.example.data.dao.PcCaseDAO
import com.example.data.entities.PcCaseEntity
import com.example.domain.entities.PcCase
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class PcCaseRepositoryImplTest {
    private val pcCaseDAO: PcCaseDAO = Mockito.mock()
    private val pcCaseRepository: PcCaseRepositoryImpl = PcCaseRepositoryImpl(pcCaseDAO)

    @Test
    fun `should return list of pc cases`() = runBlocking {
        val pcCaseEntity1: PcCaseEntity = PcCaseEntity(1, "Name", "Price", "Size", "Photo")
        val pcCaseEntity2: PcCaseEntity = PcCaseEntity(2, "Name", "Price", "Size", "Photo")
        val pcCaseEntity3: PcCaseEntity = PcCaseEntity(3, "Name", "Price", "Size", "Photo")
        val listOfPcCaseEntity: List<PcCaseEntity> = listOf(pcCaseEntity1, pcCaseEntity2, pcCaseEntity3)

        val pcCase1: PcCase = PcCase(1, "Name", "Price", "Size", "Photo")
        val pcCase2: PcCase = PcCase(2, "Name", "Price", "Size", "Photo")
        val pcCase3: PcCase = PcCase(3, "Name", "Price", "Size", "Photo")
        val expected: List<PcCase> = listOf(pcCase1, pcCase2, pcCase3)

        Mockito.`when`(pcCaseDAO.getPcCases()).thenReturn(flowOf(listOfPcCaseEntity))
        val actual: List<PcCase> = pcCaseRepository.getPcCases().last()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return pc case by id`() {
        val id: Int = 1
        val pcCaseEntity1: PcCaseEntity = PcCaseEntity(1, "Name", "Price", "Size", "Photo")
        val expected: PcCase = PcCase(1, "Name", "Price", "Size", "Photo")

        Mockito.`when`(pcCaseDAO.getPcCase(id)).thenReturn(pcCaseEntity1)
        val actual: PcCase = pcCaseRepository.getPcCase(id)

        assertEquals(expected, actual)
    }
}