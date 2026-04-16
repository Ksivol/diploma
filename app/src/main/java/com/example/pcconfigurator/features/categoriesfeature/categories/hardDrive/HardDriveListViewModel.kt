package com.example.pcconfigurator.features.categoriesfeature.categories.hardDrive

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.HardDrive
import com.example.domain.usecases.GetHardDrivesUseCase
import com.example.domain.usecases.ToggleFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HardDriveListViewModel @Inject constructor(
    private val getHardDrivesUseCase: GetHardDrivesUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase<HardDrive>,
) : ViewModel() {
    private val _hardDrives: MutableStateFlow<List<HardDrive>> = MutableStateFlow(emptyList())
    val hardDrives: StateFlow<List<HardDrive>> = _hardDrives.asStateFlow()

    fun onFavoriteClick(hardDrive: HardDrive) {
        viewModelScope.launch {
            toggleFavoriteUseCase.invoke(hardDrive)
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getHardDrivesUseCase().collect { hardDrives ->
                _hardDrives.value = hardDrives
            }
        }
    }
}
