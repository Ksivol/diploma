package com.example.data.entities.interlayer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.data.entities.PSUEntity
import com.example.data.entities.PcEntity

/**
 * Класс [IPSUEntity]. Представляет собой модельку кулера
 * с параметрами:
 * @param pcId id сборки
 * @param psuId id жёсткого диска
 * @param quantity количество

 */

@Entity(
    tableName = "q_psu",
    foreignKeys = [
        ForeignKey(
            entity = PSUEntity::class,
            parentColumns = ["id"],
            childColumns = ["psu_id"],
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

data class IPSUEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "pc_id") val pcId: Int,
    @ColumnInfo(name = "psu_id") val psuId: String,
    @ColumnInfo(name = "quantity") val quantity: String,

    )