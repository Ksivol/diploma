package com.example.pcconfigurator.features.categoriesfeature.categories.ram

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.RAM
import com.example.domain.usecases.GetRamsUseCase
import com.example.domain.usecases.ToggleFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RamListViewModel @Inject constructor(
    private val getRamsUseCase: GetRamsUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase<RAM>,
) : ViewModel() {
    private val _rams: MutableStateFlow<List<RAM>> = MutableStateFlow(emptyList())
    val rams: StateFlow<List<RAM>> = _rams.asStateFlow()

    fun onFavoriteClick(ram: RAM) {
        viewModelScope.launch {
            toggleFavoriteUseCase.invoke(ram)
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getRamsUseCase().collect { rams ->
                _rams.value = rams
            }
        }
    }
}
