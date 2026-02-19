package com.example.data.entities.interlayer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.data.entities.CoolerEntity
import com.example.data.entities.PcEntity

/**
 * Класс [ICoolerEntity]. Представляет собой модельку кулера
 * с параметрами:
 * @param pcId id сборки
 * @param coolerId id куллера
 * @param quantity количество

 */
@Entity(
    tableName = "q_cooler",
    foreignKeys = [
        ForeignKey(
            entity = CoolerEntity::class,
            parentColumns = ["id"],
            childColumns = ["cooler_id"],
            onUpdate = ForeignKey.NO_ACTION,
            onDelete = ForeignKey.NO_ACTION,
        ),
        ForeignKey(
            entity = PcEntity::class,
            parentColumns = ["id"],
            childColumns = ["pc_id"],
            onUpdate = ForeignKey.NO_ACTION,
            onDelete = ForeignKey.NO_ACTION,
        )
    ]
)

data class ICoolerEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "pc_id") val pcId: Int,
    @ColumnInfo(name = "cooler_id") val coolerId: Int,
    @ColumnInfo(name = "quantity") val quantity: Int,

    )
