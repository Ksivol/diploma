package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Класс [CoolerEntity]. Представляет собой модельку кулера
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param heatSink теплопроводность
 * @param size размер вертушков
 * @param socket подходящий сокет
 */
@Entity(tableName = "coolers")
data class CoolerEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "heatSink") val heatSink: String,
    @ColumnInfo(name = "size") val size: String,
    @ColumnInfo(name = "socket") val socket: String,
)
