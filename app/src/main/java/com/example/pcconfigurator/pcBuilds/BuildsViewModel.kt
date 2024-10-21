package com.example.pcconfigurator.pcBuilds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetBuildsUseCase
import com.example.pcconfigurator.models.Build
import com.example.pcconfigurator.utils.toPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class BuildsViewModel
    @Inject
    constructor(
        getBuildsUseCase: GetBuildsUseCase,
    ) : ViewModel() {
        init {
            viewModelScope.launch(Dispatchers.Default) {
                getBuildsUseCase.execute().collect { pcList ->
                    _builds.emit(pcList.map { it.toPresentation() })
                }
            }
        }

        private val _builds: MutableSharedFlow<List<Build>> =
            MutableSharedFlow(
                1,
                0,
                BufferOverflow.DROP_OLDEST,
            )

        val builds: SharedFlow<List<Build>> get() = _builds
    }
