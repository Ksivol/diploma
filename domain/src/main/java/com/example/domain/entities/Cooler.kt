package com.example.domain.entities

import java.math.BigDecimal

/**
 * Класс [Cooler]. Представляет собой модельку кулера
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param heatSink теплопроводность
 * @param favorite избранное
 * @param photo фото
 */
data class Cooler(
    override val id: Int,
    val name: String,
    val price: BigDecimal,
    val heatSink: Int,
    val size: Int,
    val socket: String,
    override val favorite: Boolean,
    val photo: String
): Favorite {
    override fun update(favorite: Boolean): Favorite {
        return this.copy(favorite = favorite)
    }
}
