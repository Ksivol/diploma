package com.example.domain.entities

import java.math.BigDecimal

/**
 * Класс [PcCase]. Представляет собой модельку корпуса компьютера
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param size типоразмер
 * @param favorite избранное
 * @param photo фото
 */
data class PcCase(
    override val id: Int,
    val name: String,
    val price: BigDecimal,
    val size: String,
    override val favorite: Boolean,
    val photo: String,
) : Favorite {
    override fun update(favorite: Boolean): Favorite {
        return this.copy(favorite = favorite)
    }
}
