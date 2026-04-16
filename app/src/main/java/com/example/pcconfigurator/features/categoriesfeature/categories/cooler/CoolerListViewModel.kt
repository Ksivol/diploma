package com.example.pcconfigurator.features.categoriesfeature.categories.cooler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Cooler
import com.example.domain.usecases.GetCoolersUseCase
import com.example.domain.usecases.ToggleFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoolerListViewModel @Inject constructor(
    private val getCoolersUseCase: GetCoolersUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase<Cooler>,
) : ViewModel() {
    private val _coolers: MutableStateFlow<List<Cooler>> = MutableStateFlow(emptyList())
    val coolers: StateFlow<List<Cooler>> = _coolers.asStateFlow()

    fun onFavoriteClick(cooler: Cooler) {
        viewModelScope.launch {
            toggleFavoriteUseCase.invoke(cooler)
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getCoolersUseCase().collect { coolers ->
                _coolers.value = coolers
            }
        }
    }
}
