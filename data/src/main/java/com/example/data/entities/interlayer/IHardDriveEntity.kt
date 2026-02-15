package com.example.data.entities.interlayer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.data.entities.HardDriveEntity
import com.example.data.entities.PcEntity

/**
 * Класс [IHardDriveEntity]. Представляет собой модельку кулера
 * с параметрами:
 * @param pcId id сборки
 * @param hardDriveId id жёсткого диска
 * @param quantity количество

 */

@Entity(
    tableName = "q_hard_drive",
    foreignKeys = [
        ForeignKey(
            entity = HardDriveEntity::class,
            parentColumns = ["id"],
            childColumns = ["hard_drive_id"],
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

data class IHardDriveEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "pc_id") val pcId: Int,
    @ColumnInfo(name = "hard_drive_id") val hardDriveId: String,
    @ColumnInfo(name = "quantity") val quantity: String,

    )