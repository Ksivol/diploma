package com.example.data.entities.interlayer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.data.entities.CPUEntity
import com.example.data.entities.PcEntity

/**
* Класс [ICPUEntity]. Представляет собой модельку кулера
* с параметрами:
* @param pcId id сборки
* @param cpuId id куллера
* @param quantity количество

*/
@Entity(
    tableName = "q_cpu",
    foreignKeys = [
        ForeignKey(
            entity = CPUEntity::class,
            parentColumns = ["id"],
            childColumns = ["cpu_id"],
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

data class ICPUEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "pc_id") val pcId: Int,
    @ColumnInfo(name = "cpu_id") val cpuId: Int,
    @ColumnInfo(name = "quantity") val quantity: Int,

    )