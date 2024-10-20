package com.example.domain.enitities


/**
 * Класс [Pc]. Представляет собой модельку кулера
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


data class Pc (
    val id: Int,
    val name: String,
    val price: String,
    val cooler: Cooler,
    val cpu: CPU,
    val hardDrive: HardDrive,
    val motherboard: Motherboard,
    val pcCase: PcCase,
    val psu: PSU,
    val ram: RAM,
    val videoCard: VideoCard
)


