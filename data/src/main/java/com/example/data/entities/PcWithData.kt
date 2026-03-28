package com.example.data.entities

import androidx.room.Embedded

data class PcWithData(
    val id: Int,
    val name: String,
    val price: String,
    val photo: String,
)
