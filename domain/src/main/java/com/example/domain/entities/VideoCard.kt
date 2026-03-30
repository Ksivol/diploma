package com.example.domain.entities

import java.math.BigDecimal

/**
 * Класс [VideoCard]. Представляет собой модельку видеокарты
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param clockRate тактовая частота
 * @param size размер
 * @param wattage мощность
 * @param videoMemory видеопамять
 * @param typeVideoMemory тип видеопамяти
 * @param favorite избранное
 * @param photo фото
 */
data class VideoCard(
    val id: Int,
    val name: String,
    val price: BigDecimal,
    val clockRate: Int,
    val size: Int,
    val wattage: Int,
    val videoMemory: String,
    val typeVideoMemory: String,
    val favorite: Boolean,
    val photo: String
)
