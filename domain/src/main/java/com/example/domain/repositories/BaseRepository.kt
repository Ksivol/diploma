package com.example.domain.repositories

import com.example.domain.entities.Favorite

interface BaseRepository<T : Favorite> {
    suspend fun toggleFavorite(item: T)
}