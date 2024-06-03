package com.example.data.entities

/**
 * Класс [PSU]. Представляет собой модельку блока питания
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param wattage мощность
 * @param lines ???
 */
internal data class PSU(
    val id: Int,
    val name: String,
    val price: String,
    val wattage: String,
    val lines: String
)
