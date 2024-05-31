package com.example.data.entities

/**
 * Класс [PCCase]. Представляет собой модельку корпуса компьютера
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param size размер
 */
data class PCCase(
    val id: Int,
    val name: String,
    val price: String,
    val size: String
)
