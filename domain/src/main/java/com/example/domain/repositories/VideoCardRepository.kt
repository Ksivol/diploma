package com.example.domain.repositories

import com.example.domain.entities.VideoCard
import kotlinx.coroutines.flow.Flow

interface VideoCardRepository {
    fun getVideoCards(): Flow<List<VideoCard>>

    fun getVideoCard(id: Int): VideoCard

    fun insertVideoCard(videoCard: VideoCard)

    fun updateVideoCard(videoCard: VideoCard)

    fun deleteVideoCard(videoCard: VideoCard)
}
