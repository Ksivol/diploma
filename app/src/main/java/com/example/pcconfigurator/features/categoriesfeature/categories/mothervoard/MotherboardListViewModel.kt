package com.example.pcconfigurator.features.categoriesfeature.categories.mothervoard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Motherboard
import com.example.domain.usecases.GetMotherboardsUseCase
import com.example.domain.usecases.ToggleFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MotherboardListViewModel @Inject constructor(
    private val getMotherboardsUseCase: GetMotherboardsUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase<Motherboard>,
) : ViewModel() {
    private val _motherboards: MutableStateFlow<List<Motherboard>> = MutableStateFlow(emptyList())
    val motherboards: StateFlow<List<Motherboard>> = _motherboards.asStateFlow()

    fun onFavoriteClick(motherboard: Motherboard) {
        viewModelScope.launch {
            toggleFavoriteUseCase.invoke(motherboard)
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getMotherboardsUseCase().collect { motherboards ->
                _motherboards.value = motherboards
            }
        }
    }
}
