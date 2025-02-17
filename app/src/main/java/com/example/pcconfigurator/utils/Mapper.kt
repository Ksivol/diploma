package com.example.pcconfigurator.utils

import com.example.domain.enitities.Pc
import com.example.pcconfigurator.models.Build

fun Pc.toPresentation(): Build = Build(id, name)
