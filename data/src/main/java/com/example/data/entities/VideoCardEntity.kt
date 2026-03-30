package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Класс [VideoCardEntity]. Представляет собой модельку видеокарты
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param clockRate тактовая частота
 * @param size размер
 * @param wattage мощность
 * @param videoMemory видеопамять
 * @param typeVideoMemory тип видеопамяти
 * @param favorite избранное
 * @param photo фото
 */
@Entity(tableName = "video_card")
data class VideoCardEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "clockRate") val clockRate: Int,
    @ColumnInfo(name = "size") val size: Int,
    @ColumnInfo(name = "wattage") val wattage: Int,
    @ColumnInfo(name = "videoMemory") val videoMemory: String,
    @ColumnInfo(name = "typeVideoMemory") val typeVideoMemory: String,
    @ColumnInfo(name = "favorite") val favorite: Int,
    @ColumnInfo(name = "photo") val photo: String,
)
