package com.example.domain.entities

import java.math.BigDecimal

/**
 * Класс [VideoCard]. Представляет собой модельку оперативной памяти
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param size размер карты
 * @param clockRate тактовая частота
 * @param wattage мощность
 * @param videoMemory видеопамять
 * @param typeVideoMemory тип видеопамяти
 * @param photo фото
 */
data class VideoCard(
    val id: Int,
    val name: String,
    val price: BigDecimal,
    val size: Int,
    val clockRate: Int,
    val wattage: Int,
    val videoMemory: String,
    val typeVideoMemory: String,
    val photo: String
)