package com.example.pcconfigurator.features.pcbuildsfeature.utils

import com.example.domain.entities.Pc
import com.example.pcconfigurator.features.pcbuildsfeature.models.Build

fun Pc.toPresentation(): Build = Build(id, name)
