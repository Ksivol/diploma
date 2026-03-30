package com.example.pcconfigurator.features.categoriesfeature.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Cooler
import com.example.domain.usecases.GetCoolersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoolerViewModel @Inject constructor(
    private val getCoolersUseCase: GetCoolersUseCase
) : ViewModel() {
    private val _coolers: MutableStateFlow<List<Cooler>> = MutableStateFlow(emptyList())
    val coolers: StateFlow<List<Cooler>> = _coolers.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO){
            getCoolersUseCase().collect { coolers ->
                _coolers.value = coolers
            }
        }
    }
}
