package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Класс [PSUEntity]. Представляет собой модельку блока питания
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param wattage мощность
 * @param pin_CPU пины для процессора
 * @param pin_PCI_E пины для видеокарты
 */
@Entity(tableName = "psus")
data class PSUEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "wattage") val wattage: String,
    @ColumnInfo(name = "pin_CPU") val pin_CPU: String,
    @ColumnInfo(name = "pin_PCI_E") val pin_PCI_E: String,
)
