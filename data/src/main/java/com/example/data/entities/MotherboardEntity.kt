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
 * @param favorite избранное
 * @param photo фото
 */
@Entity(tableName = "motherboard")
data class MotherboardEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "size") val size: String,
    @ColumnInfo(name = "socket") val socket: String,
    @ColumnInfo(name = "favorite") val favorite: Int,
    @ColumnInfo(name = "photo") val photo: String,
)
