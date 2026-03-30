package com.example.domain.entities

import java.math.BigDecimal


/**
 * Класс [Pc]. Представляет собой модель сбоки
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 */


data class Pc (
    val id: Int,
    val name: String,
    val price: BigDecimal,
)


