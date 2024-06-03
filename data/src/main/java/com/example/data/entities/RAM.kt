package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Класс [RAM]. Представляет собой модельку оперативной памяти
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param clockRate тактовая частота
 * @param type тип памяти
 */
@Entity(tableName = "rams")
data class RAM(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "clockRate") val clockRate: String,
    @ColumnInfo(name = "type") val type: String
)
