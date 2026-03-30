package com.example.pcconfigurator.features.categoriesfeature.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.CPU
import com.example.domain.usecases.GetCpusUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CpuViewModel @Inject constructor(
    private val getCpusUseCase: GetCpusUseCase
) : ViewModel() {
    private val _cpus: MutableStateFlow<List<CPU>> = MutableStateFlow(emptyList())
    val cpus: StateFlow<List<CPU>> = _cpus.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getCpusUseCase().collect { cpus ->
                _cpus.value = cpus
            }
        }
    }
}
