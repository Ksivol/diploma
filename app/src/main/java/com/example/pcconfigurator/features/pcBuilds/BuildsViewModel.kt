package com.example.pcconfigurator.features.pcBuilds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetBuildsUseCase
import com.example.pcconfigurator.models.Build
import com.example.pcconfigurator.utils.toPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

class BuildsViewModel
    @Inject
    constructor(
        getBuildsUseCase: GetBuildsUseCase,
    ) : ViewModel() {
        val builds: SharedFlow<List<Build>> =
            getBuildsUseCase
                .execute()
                .flowOn(Dispatchers.Default)
                .map { list -> list.map { it.toPresentation() } }
                .shareIn(viewModelScope, SharingStarted.Lazily, 1)
    }
