package com.example.data.entities

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
 */
internal data class VideoCard(
    val id: Int,
    val name: String,
    val price: String,
    val size: String,
    val clockRate: String,
    val wattage: String,
    val videoMemory: String
)