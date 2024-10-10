package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Класс [VideoCardEntity]. Представляет собой модельку оперативной памяти
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param size размер карты
 * @param clockRate тактовая частота
 * @param wattage мощность
 * @param videoMemory видеопамять
 * @param typeVideoMemory тип видеопамяти
 */
@Entity(tableName = "video_cards")
data class VideoCardEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "size") val size: String,
    @ColumnInfo(name = "clockRate") val clockRate: String,
    @ColumnInfo(name = "wattage") val wattage: String,
    @ColumnInfo(name = "videoMemory") val videoMemory: String,
    @ColumnInfo(name = "typeVideoMemory") val typeVideoMemory: String,
)
