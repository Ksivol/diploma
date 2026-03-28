package com.example.pcconfigurator.features.pcbuildsfeature.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Build(
    val id: Int,
    val title: String,
) : Parcelable