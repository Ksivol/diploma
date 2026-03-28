package com.example.data.entities.interlayer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.data.entities.MotherboardEntity
import com.example.data.entities.PcEntity

/**
 * Класс [IMotherboardEntity]. Представляет собой модельку кулера
 * с параметрами:
 * @param pcId id сборки
 * @param motherboardId id жёсткого диска
 * @param quantity количество

 */

@Entity(
    tableName = "q_motherboard",
    foreignKeys = [
        ForeignKey(
            entity = MotherboardEntity::class,
            parentColumns = ["id"],
            childColumns = ["motherboard_id"],
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

data class IMotherboardEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "pc_id") val pcId: Int,
    @ColumnInfo(name = "motherboard_id") val motherboardId: Int,
    @ColumnInfo(name = "quantity") val quantity: Int,

    )