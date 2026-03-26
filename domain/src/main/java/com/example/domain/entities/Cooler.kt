package com.example.domain.entities

import java.math.BigDecimal

/**
 * Класс [Cooler]. Представляет собой модельку кулера
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param heatSink теплопроводность
 * @param photo фото
 */
data class Cooler(
    val id: Int,
    val name: String,
    val price: BigDecimal,
    val heatSink: Int,
    val size: Int,
    val socket: String,
    val photo: String
)
