package com.example.pcconfigurator.pcBuilds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetBuildsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class BuildsViewModel
    @Inject
    constructor(
        private val getBuildsUseCase: GetBuildsUseCase,
    ) : ViewModel() {
        val builds = getBuildsUseCase.execute().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    }
