package com.naiby.kitsuchallenge.presentation.screens.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naiby.kitsuchallenge.domain.entities.AnimeEntity
import com.naiby.kitsuchallenge.domain.usecases.anime.GetAnimeByIdUseCase
import com.naiby.kitsuchallenge.presentation.events.DetailEvents
import com.naiby.kitsuchallenge.presentation.events.HomeEvents
import com.naiby.kitsuchallenge.presentation.states.DetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getAnimeByIdUseCase: GetAnimeByIdUseCase
) : ViewModel() {
    private val id: String = checkNotNull(savedStateHandle.get<String>("id"))

    private val _uiState = MutableStateFlow<DetailState>(DetailState.IsLoading)
    val uiState = _uiState.asStateFlow()

    init {
        handleEvents(DetailEvents.FetchAnime)
    }

    private fun getAnimeBId() = viewModelScope.launch {
        getAnimeByIdUseCase(id).fold(
            onSuccess = {
                _uiState.value = DetailState.Success(it)
            },
            onFailure = {
                _uiState.value = DetailState.Error(it)
            }
        )
    }

    fun handleEvents(events: DetailEvents){
        when(events){
            is DetailEvents.FetchAnime -> getAnimeBId()
        }
    }
}