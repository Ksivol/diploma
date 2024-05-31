package com.example.data.entities

/**
 * Класс [Motherboard]. Представляет собой модельку материнской платы
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param size размер
 * @param socket сокет
 */
data class Motherboard(
    val id: Int,
    val name: String,
    val price: String,
    val size: Int,
    val socket: String
)
