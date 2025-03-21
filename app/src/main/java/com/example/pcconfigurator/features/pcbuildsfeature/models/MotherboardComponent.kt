package com.example.pcconfigurator.features.pcbuildsfeature.models

/**
 * Класс [MotherboardComponent]. Представляет собой модельку материнской платы
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param photo фото
 */
data class MotherboardComponent(
    override val id: Int,
    override val name: String,
    override val price: String,
    override val photo: String
) : PluggableComponent(id, name, price, photo)
