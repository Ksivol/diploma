package com.example.data.repositories

import com.example.data.dao.VideoCardDAO
import com.example.data.entities.VideoCardEntity
import com.example.domain.entities.VideoCard
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class VideoCardRepositoryImplTest {
    private val videoCardDAO: VideoCardDAO = Mockito.mock()
    private val videoCardRepository: VideoCardRepositoryImpl = VideoCardRepositoryImpl(videoCardDAO)

    @Test
    fun `should return list of video cards`() = runBlocking {
        val videoCardEntity1: VideoCardEntity =
            VideoCardEntity(1, "Name", "Price", "Size", "ClockRate", "Wattage", "VideoMemory", "TypeVideoMemory", "Photo")
        val videoCardEntity2: VideoCardEntity =
            VideoCardEntity(2, "Name", "Price", "Size", "ClockRate", "Wattage", "VideoMemory", "TypeVideoMemory", "Photo")
        val videoCardEntity3: VideoCardEntity =
            VideoCardEntity(3, "Name", "Price", "Size", "ClockRate", "Wattage", "VideoMemory", "TypeVideoMemory", "Photo")
        val listOfVideoCardEntity: List<VideoCardEntity> = listOf(videoCardEntity1, videoCardEntity2, videoCardEntity3)

        val videoCard1: VideoCard =
            VideoCard(1, "Name", "Price", "Size", "ClockRate", "Wattage", "VideoMemory", "TypeVideoMemory", "Photo")
        val videoCard2: VideoCard =
            VideoCard(2, "Name", "Price", "Size", "ClockRate", "Wattage", "VideoMemory", "TypeVideoMemory", "Photo")
        val videoCard3: VideoCard =
            VideoCard(3, "Name", "Price", "Size", "ClockRate", "Wattage", "VideoMemory", "TypeVideoMemory", "Photo")
        val expected: List<VideoCard> = listOf(videoCard1, videoCard2, videoCard3)

        Mockito.`when`(videoCardDAO.getVideoCards()).thenReturn(flowOf(listOfVideoCardEntity))

        val actual: List<VideoCard> = videoCardRepository.getVideoCards().last()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return video card by id`() {
        val id: Int = 1
        val videoCardEntity1: VideoCardEntity =
            VideoCardEntity(1, "Name", "Price", "Size", "ClockRate", "Wattage", "VideoMemory", "TypeVideoMemory", "Photo")
        val expected: VideoCard =
            VideoCard(1, "Name", "Price", "Size", "ClockRate", "Wattage", "VideoMemory", "TypeVideoMemory", "Photo")

        Mockito.`when`(videoCardDAO.getVideoCard(id)).thenReturn(videoCardEntity1)

        val actual: VideoCard = videoCardRepository.getVideoCard(id)

        assertEquals(expected, actual)
    }
}