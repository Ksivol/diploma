package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Класс [Cooler]. Представляет собой модельку кулера
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param heatSink теплопроводность
 */
@Entity(tableName = "cooler")
internal data class Cooler(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "heatSink") val heatSink: String
)
