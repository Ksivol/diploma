package com.example.data.entities

/**
 * Класс [CPU]. Представляет собой модельку ЦПУ
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param socket сокет
 * @param clockRate тактовая частота
 * @param wattage потребляемая мощность
 */
data class CPU(
    val id: Int,
    val name: String,
    val price: String,
    val socket: String,
    val clockRate: String,
    val wattage: String
)
