package com.example.pcconfigurator.features.pcbuildsfeature.models

/**
 * Класс [PsuComponent]. Представляет собой модельку блока питания
 * с параметрами:
 * @param id уникальный id
 * @param name имя модели
 * @param price цена
 * @param photo фото
 */
data class PsuComponent(
    override val id: Int,
    override val name: String,
    override val price: String,
    override val photo: String,
) : PluggableComponent(id, name, price, photo)
