package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Класс [MotherboardEntity]. Представляет собой модельку материнской платы
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param size размер
 * @param socket сокет
 */
@Entity(tableName = "motherboards")
data class MotherboardEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "size") val size: Int,
    @ColumnInfo(name = "socket") val socket: String,
)
