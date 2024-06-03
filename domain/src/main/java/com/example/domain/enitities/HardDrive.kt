package com.example.domain.enitities

/**
 * Класс [HardDrive]. Представляет собой модельку жесткого диска
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param capacity объем памяти
 * @param type тип (SSD SATA, SSD M2, HDD)
 * @param size размер жесткого диска?
 * @param overwrite кол-во перезаписей
 */
data class HardDrive(
    val id: Int,
    val name: String,
    val price: String,
    val capacity: Int,
    val type: Int,
    val size: String,
    val overwrite: Int
)
