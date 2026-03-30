package com.example.pcconfigurator.features.categoriesfeature.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Motherboard
import com.example.domain.usecases.GetMotherboardsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MotherboardViewModel @Inject constructor(
    private val getMotherboardsUseCase: GetMotherboardsUseCase
) : ViewModel() {
    private val _motherboards: MutableStateFlow<List<Motherboard>> = MutableStateFlow(emptyList())
    val motherboards: StateFlow<List<Motherboard>> = _motherboards.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getMotherboardsUseCase().collect { motherboards ->
                _motherboards.value = motherboards
            }
        }
    }
}
