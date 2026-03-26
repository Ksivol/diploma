package com.example.data.repositories

import com.example.data.dao.HardDriveDAO
import com.example.data.entities.HardDriveEntity
import com.example.domain.entities.HardDrive
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class HardDriveRepositoryImplTest {
    private val hardDriveDAO: HardDriveDAO = Mockito.mock()
    private val hardDriveRepository: HardDriveRepositoryImpl = HardDriveRepositoryImpl(hardDriveDAO)

    @Test
    fun `should return list of hard drives`() = runBlocking {
        val hardDriveEntity1: HardDriveEntity =
            HardDriveEntity(1, "Name", "Price", 0, "Type", "Size", 0, "Photo")
        val hardDriveEntity2: HardDriveEntity =
            HardDriveEntity(1, "Name", "Price", 0, "Type", "Size", 0, "Photo")
        val hardDriveEntity3: HardDriveEntity =
            HardDriveEntity(1, "Name", "Price", 0, "Type", "Size", 0, "Photo")
        val listOfHardDriveEntity: List<HardDriveEntity> = listOf(hardDriveEntity1, hardDriveEntity2, hardDriveEntity3)

        val hardDrive1: HardDrive =
            HardDrive(1, "Name", "Price", 0, "Type", "Size", 0, "Photo")
        val hardDrive2: HardDrive =
            HardDrive(1, "Name", "Price", 0, "Type", "Size", 0, "Photo")
        val hardDrive3: HardDrive =
            HardDrive(1, "Name", "Price", 0, "Type", "Size", 0, "Photo")
        val expected: List<HardDrive> = listOf(hardDrive1, hardDrive2, hardDrive3)

        Mockito.`when`(hardDriveDAO.getHardDrives()).thenReturn(flowOf(listOfHardDriveEntity))
        val actual: List<HardDrive> = hardDriveRepository.getHardDrives().last()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return hard drive by id`(){
        val id: Int = 1
        val hardDriveEntity1: HardDriveEntity =
            HardDriveEntity(1, "Name", "Price", 0, "Type", "Size", 0, "Photo")
        val expected: HardDrive =
            HardDrive(1, "Name", "Price", 0, "Type", "Size", 0, "Photo")

        Mockito.`when`(hardDriveDAO.getHardDrive(id)).thenReturn(hardDriveEntity1)
        val actual: HardDrive = hardDriveRepository.getHardDrive(id)

        assertEquals(expected, actual)
    }
}