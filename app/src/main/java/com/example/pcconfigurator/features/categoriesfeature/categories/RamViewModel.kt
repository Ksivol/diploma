package com.example.pcconfigurator.features.categoriesfeature.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.RAM
import com.example.domain.usecases.GetRamsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RamViewModel @Inject constructor(
    private val getRamsUseCase: GetRamsUseCase
) : ViewModel() {
    private val _rams: MutableStateFlow<List<RAM>> = MutableStateFlow(emptyList())
    val rams: StateFlow<List<RAM>> = _rams.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getRamsUseCase().collect { rams ->
                _rams.value = rams
            }
        }
    }
}
