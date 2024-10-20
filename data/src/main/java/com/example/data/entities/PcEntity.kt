package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.domain.enitities.CPU
import com.example.domain.enitities.Cooler
import com.example.domain.enitities.HardDrive
import com.example.domain.enitities.Motherboard
import com.example.domain.enitities.PSU
import com.example.domain.enitities.PcCase
import com.example.domain.enitities.RAM
import com.example.domain.enitities.VideoCard

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
@Entity(tableName = "Pc", foreignKeys = [
    ForeignKey(entity = Cooler::class, parentColumns = ["id"], childColumns = ["coolerID"]),
    ForeignKey(entity = CPU::class, parentColumns = ["id"], childColumns = ["cpuID"]),
    ForeignKey(entity = HardDrive::class, parentColumns = ["id"], childColumns = ["hardDriveID"]),
    ForeignKey(entity = Motherboard::class, parentColumns = ["id"], childColumns = ["motherboardID"]),
    ForeignKey(entity = PcCase::class, parentColumns = ["id"], childColumns = ["pcCaseID"]),
    ForeignKey(entity = PSU::class, parentColumns = ["id"], childColumns = ["psuID"]),
    ForeignKey(entity = RAM::class, parentColumns = ["id"], childColumns = ["ramID"]),
    ForeignKey(entity = VideoCard::class, parentColumns = ["id"], childColumns = ["videoCardID"]),
])
data class PcEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "coolerID") val coolerID: Int,
    @ColumnInfo(name = "cpuID") val cpuID: Int,
    @ColumnInfo(name = "hardDriveID") val hardDriveID: Int,
    @ColumnInfo(name = "motherboardID") val motherboardID: Int,
    @ColumnInfo(name = "pcCaseID") val pcCaseID: Int,
    @ColumnInfo(name = "psuID") val psuID: Int,
    @ColumnInfo(name = "ramID") val ramID: Int,
    @ColumnInfo(name = "videoCardID") val videoCardID: Int
)



