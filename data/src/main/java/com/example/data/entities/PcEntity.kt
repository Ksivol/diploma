package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.data.entities.interlayer.ICPUEntity
import com.example.data.entities.interlayer.ICoolerEntity

/**
 * Класс [PcEntity]. Представляет собой модельку кулера
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param photo: видео карта
 */
@Entity(
    tableName = "pc",
)
data class PcEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "photo") val photo: String
)
