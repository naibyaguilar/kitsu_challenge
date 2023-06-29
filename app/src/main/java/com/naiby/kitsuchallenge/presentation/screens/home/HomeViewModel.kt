package com.naiby.kitsuchallenge.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naiby.kitsuchallenge.domain.entities.AnimeEntity
import com.naiby.kitsuchallenge.domain.usecases.anime.GetAnimesUseCase
import com.naiby.kitsuchallenge.presentation.events.HomeEvents
import com.naiby.kitsuchallenge.presentation.states.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAnimesUseCase: GetAnimesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeState<List<AnimeEntity>>>(HomeState.IsLoading)
    val uiState = _uiState.asStateFlow()

    init {
        handleEvents(HomeEvents.FetchAnimes)
    }

    private fun getAnime() = viewModelScope.launch {
        getAnimesUseCase().fold(
            onSuccess = {
                _uiState.value = HomeState.Success(it)
            },
            onFailure = {
                _uiState.value = HomeState.Error(it)
            }
        )
    }

    fun handleEvents(events: HomeEvents) {
        when (events) {
            is HomeEvents.FetchAnimes -> getAnime()
        }
    }

}