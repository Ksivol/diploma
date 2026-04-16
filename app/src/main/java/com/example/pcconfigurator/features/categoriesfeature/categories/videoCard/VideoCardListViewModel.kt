package com.example.pcconfigurator.features.categoriesfeature.categories.videoCard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.VideoCard
import com.example.domain.usecases.GetVideoCardsUseCase
import com.example.domain.usecases.ToggleFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class VideoCardListViewModel @Inject constructor(
    private val getVideoCardsUseCase: GetVideoCardsUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase<VideoCard>,
) : ViewModel() {
    private val _videoCards: MutableStateFlow<List<VideoCard>> = MutableStateFlow(emptyList())
    val videoCards: StateFlow<List<VideoCard>> = _videoCards.asStateFlow()

    fun onFavoriteClick(videoCard: VideoCard) {
        viewModelScope.launch {
            toggleFavoriteUseCase.invoke(videoCard)
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getVideoCardsUseCase().collect { videoCards ->
                _videoCards.value = videoCards
            }
        }
    }
}
