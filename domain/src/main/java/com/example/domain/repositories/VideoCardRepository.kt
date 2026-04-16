package com.example.domain.repositories

import com.example.domain.entities.CPU
import com.example.domain.entities.VideoCard
import kotlinx.coroutines.flow.Flow

interface VideoCardRepository: BaseRepository<VideoCard> {
    fun getVideoCards(): Flow<List<VideoCard>>

    suspend fun getVideoCard(id: Int): VideoCard

    suspend fun updateVideoCard(videoCard: VideoCard)
}
