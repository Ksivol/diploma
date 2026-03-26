package com.example.domain.entities

import java.math.BigDecimal

/**
 * Класс [PcCase]. Представляет собой модельку корпуса компьютера
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param photo фото
 */
data class PcCase(
    val id: Int,
    val name: String,
    val price: BigDecimal,
    val size: String,
    val photo: String,
)
