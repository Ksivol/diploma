package com.example.domain.entities

import java.math.BigDecimal

/**
 * Класс [CPU]. Представляет собой модельку ЦПУ
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param socket сокет
 * @param clockRate тактовая частота
 * @param wattage потребляемая мощность
 * @param favorite избранное
 * @param photo фото
 */
data class CPU(
    override val id: Int,
    val name: String,
    val price: BigDecimal,
    val socket: String,
    val clockRate: String,
    val wattage: Int,
    override val favorite: Boolean,
    val photo: String,
) : Favorite {
    override fun update(favorite: Boolean): Favorite {
        return this.copy(favorite = favorite)
    }
}
