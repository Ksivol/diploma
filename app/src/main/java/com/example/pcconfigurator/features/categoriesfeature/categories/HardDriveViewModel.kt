package com.example.pcconfigurator.features.categoriesfeature.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.HardDrive
import com.example.domain.usecases.GetHardDrivesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HardDriveViewModel @Inject constructor(
    private val getHardDrivesUseCase: GetHardDrivesUseCase
) : ViewModel() {
    private val _hardDrives: MutableStateFlow<List<HardDrive>> = MutableStateFlow(emptyList())
    val hardDrives: StateFlow<List<HardDrive>> = _hardDrives.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getHardDrivesUseCase().collect { hardDrives ->
                _hardDrives.value = hardDrives
            }
        }
    }
}
