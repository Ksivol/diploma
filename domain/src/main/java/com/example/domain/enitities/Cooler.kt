package com.example.domain.enitities

/**
 * Класс [Cooler]. Представляет собой модельку кулера
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param heatSink теплопроводность
 */
data class Cooler(
    val id: Int,
    val name: String,
    val price: String,
    val heatSink: String,
    val size: String,
    val socket: String
)
