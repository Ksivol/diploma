package com.example.data.entities

/**
 * Класс [PcCase]. Представляет собой модельку корпуса компьютера
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param size размер
 */
internal data class PcCase(
    val id: Int,
    val name: String,
    val price: String,
    val size: String
)
