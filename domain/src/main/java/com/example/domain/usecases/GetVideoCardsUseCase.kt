package com.example.domain.usecases

import com.example.domain.entities.VideoCard
import com.example.domain.repositories.VideoCardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVideoCardsUseCase @Inject constructor(private val repository: VideoCardRepository) {
    operator fun invoke(): Flow<List<VideoCard>> = repository.getVideoCards()
}
