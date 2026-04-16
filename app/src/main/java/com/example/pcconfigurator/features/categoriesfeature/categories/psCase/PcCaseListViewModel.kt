package com.example.pcconfigurator.features.categoriesfeature.categories.psCase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.PcCase
import com.example.domain.usecases.GetPcCasesUseCase
import com.example.domain.usecases.ToggleFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PcCaseListViewModel @Inject constructor(
    private val getPcCasesUseCase: GetPcCasesUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase<PcCase>,
) : ViewModel() {
    private val _pcCases: MutableStateFlow<List<PcCase>> = MutableStateFlow(emptyList())
    val pcCases: StateFlow<List<PcCase>> = _pcCases.asStateFlow()

    fun onFavoriteClick(pcCase: PcCase) {
        viewModelScope.launch {
            toggleFavoriteUseCase.invoke(pcCase)
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getPcCasesUseCase().collect { pcCases ->
                _pcCases.value = pcCases
            }
        }
    }
}
