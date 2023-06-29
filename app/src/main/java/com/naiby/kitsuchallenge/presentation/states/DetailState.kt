package com.naiby.kitsuchallenge.presentation.states

import com.naiby.kitsuchallenge.domain.entities.AnimeEntity
import java.lang.Exception

sealed class DetailState{
    object IsLoading : DetailState()

    data class Success (val data: AnimeEntity) : DetailState()
    data class Error (val exception: Exception) : DetailState()

}
