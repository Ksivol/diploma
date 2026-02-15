package com.example.data.entities.interlayer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.data.entities.PcCaseEntity
import com.example.data.entities.PcEntity

/**
 * Класс [IPcCaseEntity]. Представляет собой модельку кулера
 * с параметрами:
 * @param pcId id сборки
 * @param caseId id жёсткого диска
 * @param quantity количество

 */

@Entity(
    tableName = "q_case",
    foreignKeys = [
        ForeignKey(
            entity = PcCaseEntity::class,
            parentColumns = ["id"],
            childColumns = ["case_id"],
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

data class IPcCaseEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "pc_id") val pcId: Int,
    @ColumnInfo(name = "case_id") val caseId: String,
    @ColumnInfo(name = "quantity") val quantity: String,

    )