package com.example.domain.entities

import java.math.BigDecimal

/**
 * Класс [PSU]. Представляет собой модельку блока питания
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param wattage мощность
 * @param pinCPU пины для процессора
 * @param pinPCIE пины для видеокарты
 * @param favorite избранное
 * @param photo фото
 */
data class PSU(
    override val id: Int,
    val name: String,
    val price: BigDecimal,
    val wattage: String,
    val pinCPU: String,
    val pinPCIE: String,
    override val favorite: Boolean,
    val photo: String,
) : Favorite {
    override fun update(favorite: Boolean): Favorite {
        return this.copy(favorite = favorite)
    }
}
