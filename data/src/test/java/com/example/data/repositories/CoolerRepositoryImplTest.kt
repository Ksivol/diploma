package com.example.data.repositories

import com.example.data.dao.CoolerDAO
import com.example.data.entities.CoolerEntity
import com.example.domain.enitities.Cooler
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class CoolerRepositoryImplTest {

    private val coolerDAO: CoolerDAO = mock()
    private val coolerRepositoryImpl: CoolerRepositoryImpl = CoolerRepositoryImpl(coolerDAO)

    @Test
    fun `should return list of Cooler`() = runBlocking {
        val coolerEntity1: CoolerEntity = CoolerEntity(1, "Name1", "Price1", "HeatSink1", "Size1", "Socket1", "Photo1")
        val coolerEntity2: CoolerEntity = CoolerEntity(2, "Name2", "Price2", "HeatSink2", "Size2", "Socket2", "Photo2")
        val coolerEntity3: CoolerEntity = CoolerEntity(3, "Name3", "Price3", "HeatSink3", "Size3", "Socket3", "Photo3")
        val coolerEntityList: List<CoolerEntity> = listOf(coolerEntity1, coolerEntity2, coolerEntity3)

        val cooler1: Cooler =
            Cooler(1, "Name1", "Price1", "HeatSink1", "Size1", "Socket1", "Photo1")
        val cooler2: Cooler =
            Cooler(2, "Name2", "Price2", "HeatSink2", "Size2", "Socket2", "Photo2")
        val cooler3: Cooler =
            Cooler(3, "Name3", "Price3", "HeatSink3", "Size3", "Socket3", "Photo3")
        val expected: List<Cooler> = listOf(cooler1, cooler2, cooler3)

        Mockito.`when`(coolerDAO.getCoolers()).thenReturn(flowOf(coolerEntityList))
        val actual = coolerRepositoryImpl.getCoolers().last()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return cooler by id`() {
        val id: Int = 1
        val coolerEntity1: CoolerEntity =
            CoolerEntity(1, "Name1", "Price1", "HeatSink1", "Size1", "Socket1", "Photo1")
        val expected: Cooler =
            Cooler(1, "Name1", "Price1", "HeatSink1", "Size1", "Socket1", "Photo1")

        Mockito.`when`(coolerDAO.getCooler(id)).thenReturn(coolerEntity1)
        val actual: Cooler = coolerRepositoryImpl.getCooler(id)

        assertEquals(expected,actual)
    }
}