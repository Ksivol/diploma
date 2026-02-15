package com.example.data.entities.interlayer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.data.entities.PcEntity
import com.example.data.entities.VideoCardEntity

/**
 * Класс [IVideoCardEntity]. Представляет собой модельку кулера
 * с параметрами:
 * @param pcId id сборки
 * @param videoCardId id куллера
 * @param quantity количество

 */


@Entity(
    tableName = "q_video_card",
    foreignKeys = [
        ForeignKey(
            entity = VideoCardEntity::class,
            parentColumns = ["id"],
            childColumns = ["video_card_id"],
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

data class IVideoCardEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "pc_id") val pcId: Int,
    @ColumnInfo(name = "video_card_id") val videoCardId: String,
    @ColumnInfo(name = "quantity") val quantity: String,

    )