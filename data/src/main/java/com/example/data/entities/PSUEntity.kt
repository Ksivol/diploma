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
 * @param photo фото
 */
@Entity(tableName = "psus")
data class PSUEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "wattage") val wattage: String,
    @ColumnInfo(name = "pinCPU") val pinCPU: String,
    @ColumnInfo(name = "pinPCIE") val pinPCIE: String,
    @ColumnInfo(name = "photo") val photo: String,
)
