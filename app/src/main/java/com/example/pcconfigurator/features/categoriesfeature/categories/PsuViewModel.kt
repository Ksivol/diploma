package com.example.pcconfigurator.features.categoriesfeature.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.PSU
import com.example.domain.usecases.GetPsusUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PsuViewModel @Inject constructor(
    private val getPsusUseCase: GetPsusUseCase
) : ViewModel() {
    private val _psus: MutableStateFlow<List<PSU>> = MutableStateFlow(emptyList())
    val psus: StateFlow<List<PSU>> = _psus.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getPsusUseCase().collect { psus ->
                _psus.value = psus
            }
        }
    }
}
