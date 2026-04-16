package com.example.domain.usecases

import com.example.domain.entities.Favorite
import com.example.domain.repositories.BaseRepository
import javax.inject.Inject

class ToggleFavoriteUseCase<T : Favorite>
@Inject
constructor(
    private val repository: BaseRepository<T>
) {
    @Suppress("UNCHECKED_CAST")
    suspend operator fun invoke(item: T) {
        val tempItem: T = if (item.favorite) {
            item.update(false) as T
        } else {
            item.update(true) as T
        }
        repository.toggleFavorite(tempItem)
    }
}