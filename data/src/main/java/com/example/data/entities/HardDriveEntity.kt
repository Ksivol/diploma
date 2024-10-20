package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Класс [HardDriveEntity]. Представляет собой модельку жесткого диска
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param capacity объем памяти
 * @param type тип (SSD SATA, SSD M2, HDD)
 * @param size размер жесткого диска?
 * @param photo фото
 */
@Entity(tableName = "hard_drives")
data class HardDriveEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "capacity") val capacity: Int,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "size") val size: String,
    @ColumnInfo(name = "overwrite") val overwrite: Int,
    @ColumnInfo(name = "photo") val photo: String,
)
