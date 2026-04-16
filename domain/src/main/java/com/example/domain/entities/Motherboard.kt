package com.example.domain.entities

import java.math.BigDecimal

/**
 * Класс [Motherboard]. Представляет собой модельку материнской платы
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param size размер
 * @param socket сокет
 * @param favorite избранное
 * @param photo фото
 */
data class Motherboard(
    override val id: Int,
    val name: String,
    val price: BigDecimal,
    val size: String,
    val socket: String,
    override val favorite: Boolean,
    val photo: String
) : Favorite {
    override fun update(favorite: Boolean): Favorite {
        return this.copy(favorite = favorite)
    }
}
