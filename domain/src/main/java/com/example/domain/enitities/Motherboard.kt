package com.example.domain.enitities

/**
 * Класс [Motherboard]. Представляет собой модельку материнской платы
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param size размер
 * @param socket сокет
 * @param photo фото
 */
data class Motherboard(
    val id: Int,
    val name: String,
    val price: String,
    val size: String,
    val socket: String,
    val photo: String
)
