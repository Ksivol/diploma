package com.example.data.entities

/**
 * Класс [RAM]. Представляет собой модельку оперативной памяти
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param clockRate тактовая частота
 * @param type тип памяти
 */
data class RAM(
    val id: Int,
    val name: String,
    val price: String,
    val clockRate: String,
    val type: String
)
