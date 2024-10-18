package com.example.domain.enitities

/**
 * Класс [RAM]. Представляет собой модельку оперативной памяти
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param clockRate тактовая частота
 * @param type тип памяти
 * @param photo фото
 */
data class RAM(
    val id: Int,
    val name: String,
    val price: String,
    val clockRate: String,
    val type: String,
    val photo: String
)
