package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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
@Entity(tableName = "cpu")
internal data class CPU(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "socket") val socket: String,
    @ColumnInfo(name = "clockRate") val clockRate: String,
    @ColumnInfo(name = "wattage") val wattage: String
)
