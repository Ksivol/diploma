package com.example.data.repositories

import com.example.data.dao.VideoCardDAO
import com.example.data.entities.VideoCardEntity
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import com.example.domain.enitities.VideoCard
import com.example.domain.repositories.VideoCardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VideoCardRepositoryImpl
    @Inject
    constructor(
        private val videoCardDAO: VideoCardDAO,
    ) : VideoCardRepository {
        override fun getVideoCards(): Flow<List<VideoCard>> = videoCardDAO.getVideoCards().map { it.map(VideoCardEntity::toDomain) }

        override fun getVideoCard(id: Int): VideoCard = videoCardDAO.getVideoCard(id).toDomain()

        override fun insertVideoCard(videoCard: VideoCard) {
            videoCardDAO.insertVideoCard(videoCard.toData())
        }

        override fun updateVideoCard(videoCard: VideoCard) {
            videoCardDAO.updateVideoCard(videoCard.toData())
        }

        override fun deleteVideoCard(videoCard: VideoCard) {
            videoCardDAO.deleteVideoCard(videoCard.toData())
        }
    }
