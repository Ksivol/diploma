package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * Класс [PC]. Представляет собой модельку кулера
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param cooler: кулер
 * @param cpu: процессор
 * @param hardDrive: жёсткий диск
 * @param motherboard: материнская плата
 * @param pcCase: корпус
 * @param psu: блок питания
 * @param ram: оперативная память
 * @param videoCard: видео карта
 */
@Entity(
    tableName = "Pc",
    foreignKeys = [
        ForeignKey(
            entity = CoolerEntity::class,
            parentColumns = ["id"],
            childColumns = ["cooler"],
            onUpdate = ForeignKey.NO_ACTION,
            onDelete = ForeignKey.NO_ACTION,
        ),
        ForeignKey(
            entity = CPUEntity::class,
            parentColumns = ["id"],
            childColumns = ["cpu"],
            onUpdate = ForeignKey.NO_ACTION,
            onDelete = ForeignKey.NO_ACTION,
        ),
        ForeignKey(
            entity = HardDriveEntity::class,
            parentColumns = ["id"],
            childColumns = ["hardDrive"],
            onUpdate = ForeignKey.NO_ACTION,
            onDelete = ForeignKey.NO_ACTION,
        ),
        ForeignKey(
            entity = MotherboardEntity::class,
            parentColumns = ["id"],
            childColumns = ["motherboard"],
            onUpdate = ForeignKey.NO_ACTION,
            onDelete = ForeignKey.NO_ACTION,
        ),
        ForeignKey(
            entity = PcCaseEntity::class,
            parentColumns = ["id"],
            childColumns = ["pcCase"],
            onUpdate = ForeignKey.NO_ACTION,
            onDelete = ForeignKey.NO_ACTION,
        ),
        ForeignKey(
            entity = PSUEntity::class,
            parentColumns = ["id"],
            childColumns = ["psu"],
            onUpdate = ForeignKey.NO_ACTION,
            onDelete = ForeignKey.NO_ACTION,
        ),
        ForeignKey(
            entity = RAMEntity::class,
            parentColumns = ["id"],
            childColumns = ["ram"],
            onUpdate = ForeignKey.NO_ACTION,
            onDelete = ForeignKey.NO_ACTION,
        ),
        ForeignKey(
            entity = VideoCardEntity::class,
            parentColumns = ["id"],
            childColumns = ["videoCard"],
            onUpdate = ForeignKey.NO_ACTION,
            onDelete = ForeignKey.NO_ACTION,
        ),
    ],
)
data class PcEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "cpu") val cpu: Int,
    @ColumnInfo(name = "cooler") val cooler: Int?,
    @ColumnInfo(name = "hardDrive") val hardDrive: Int?,
    @ColumnInfo(name = "motherboard") val motherboard: Int?,
    @ColumnInfo(name = "pcCase") val pcCase: Int?,
    @ColumnInfo(name = "psu") val psu: Int?,
    @ColumnInfo(name = "ram") val ram: Int?,
    @ColumnInfo(name = "videoCard") val videoCard: Int?,
)
