package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Класс [PcCaseEntity]. Представляет собой модельку корпуса компьютера
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param size размер
 * @param favorite избранное
 * @param photo фото
 */
@Entity(tableName = "pc_case")
data class PcCaseEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "size") val size: String,
    @ColumnInfo(name = "favorite") val favorite: Int,
    @ColumnInfo(name = "photo") val photo: String,
)
