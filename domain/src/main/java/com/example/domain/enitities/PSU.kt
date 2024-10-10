package com.example.domain.enitities

/**
 * Класс [PSU]. Представляет собой модельку блока питания
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param wattage мощность
 * @param pin_CPU пины для процессора
 * @param pin_PCI_E пины для видеокарты
 */
data class PSU(
    val id: Int,
    val name: String,
    val price: String,
    val wattage: String,
    val pin_CPU: String,
    val pin_PCI_E: String,
)
