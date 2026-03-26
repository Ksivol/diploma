package com.example.domain.entities

import java.math.BigDecimal

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
 * @param photo фото
 */
data class HardDrive(
    val id: Int,
    val name: String,
    val price: BigDecimal,
    val capacity: String,
    val type: String,
    val overwrite: String,
    val photo: String
)
