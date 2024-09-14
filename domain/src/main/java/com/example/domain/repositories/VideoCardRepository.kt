package com.example.domain.repositories

import com.example.domain.enitities.VideoCard
import kotlinx.coroutines.flow.Flow

interface VideoCardRepository {
    fun getVideoCards(): Flow<List<VideoCard>>

    fun insertVideoCard(videoCard: VideoCard)

    fun updateVideoCard(videoCard: VideoCard)

    fun deleteVideoCard(videoCard: VideoCard)
}
