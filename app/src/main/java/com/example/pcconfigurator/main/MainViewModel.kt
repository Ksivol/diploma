package com.example.pcconfigurator.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel
    @Inject
    constructor() : ViewModel() {
        private val innerTitle: MutableStateFlow<String> = MutableStateFlow("")
        val title = innerTitle.asStateFlow()

        fun setTitle(string: String) =
            viewModelScope.launch(Dispatchers.IO) {
                innerTitle.emit(string)
            }
    }
