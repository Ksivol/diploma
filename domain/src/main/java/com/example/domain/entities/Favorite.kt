package com.example.domain.entities

interface Favorite {
    val id: Int
    val favorite: Boolean

    fun update(favorite: Boolean): Favorite
}
