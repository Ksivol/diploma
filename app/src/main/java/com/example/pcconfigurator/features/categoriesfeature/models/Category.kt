package com.example.pcconfigurator.features.categoriesfeature.models

import androidx.annotation.DrawableRes

data class Category(
    val id: Int,
    @DrawableRes val image: Int,
    val title: String,
)