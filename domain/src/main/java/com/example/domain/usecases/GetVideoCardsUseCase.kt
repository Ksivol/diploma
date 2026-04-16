package com.example.domain.usecases

import com.example.domain.entities.VideoCard
import com.example.domain.repositories.VideoCardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetVideoCardsUseCase @Inject constructor(private val repository: VideoCardRepository) {
    suspend operator fun invoke(): Flow<List<VideoCard>> =
        withContext(Dispatchers.IO) { repository.getVideoCards() }
}
