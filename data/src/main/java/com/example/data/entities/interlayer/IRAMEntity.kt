package com.example.data.entities.interlayer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.data.entities.PcEntity
import com.example.data.entities.RAMEntity

/**
 * Класс [IRAMEntity]. Представляет собой модельку кулера
 * с параметрами:
 * @param pcId id сборки
 * @param ramId id жёсткого диска
 * @param quantity количество

 */

@Entity(
    tableName = "q_ram",
    foreignKeys = [
        ForeignKey(
            entity = RAMEntity::class,
            parentColumns = ["id"],
            childColumns = ["ram_id"],
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

data class IRAMEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "pc_id") val pcId: Int,
    @ColumnInfo(name = "ram_id") val ramId: String,
    @ColumnInfo(name = "quantity") val quantity: String,

    )