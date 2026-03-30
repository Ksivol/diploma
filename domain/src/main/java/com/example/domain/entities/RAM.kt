package com.example.domain.entities

import java.math.BigDecimal

/**
 * Класс [RAM]. Представляет собой модельку оперативной памяти
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param clockRate тактовая частота
 * @param type тип памяти
 * @param quantity конфигурация модулей
 * @param favorite избранное
 * @param photo фото
 */
data class RAM(
    val id: Int,
    val name: String,
    val price: BigDecimal,
    val clockRate: Int,
    val type: String,
    val quantity: String,
    val favorite: Boolean,
    val photo: String
)
