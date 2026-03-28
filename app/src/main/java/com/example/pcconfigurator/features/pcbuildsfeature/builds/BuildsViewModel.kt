package com.example.pcconfigurator.features.pcbuildsfeature.builds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.enitities.Pc
import com.example.domain.usecases.GetBuildsUseCase
import com.example.pcconfigurator.features.pcbuildsfeature.makeabuild.MakeABuildFragment
import com.example.pcconfigurator.features.pcbuildsfeature.utils.toPresentation
import com.example.pcconfigurator.features.pcbuildsfeature.models.Build
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

class BuildsViewModel @Inject constructor(getBuildsUseCase: GetBuildsUseCase, private val router: Router) : ViewModel() {
    val builds: SharedFlow<List<Build>> = getBuildsUseCase
        .execute()
        .flowOn(Dispatchers.Default)
        .map { it.map(Pc::toPresentation) }
        .shareIn(viewModelScope, SharingStarted.Lazily, 1)

    fun navigateToMakeABuild() {
        router.navigateTo(MakeABuildFragment.Screen())
    }
}
