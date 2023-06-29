package com.naiby.kitsuchallenge.presentation.states


sealed class HomeState<out T> {
    object IsLoading : HomeState<Nothing>()

    data class Success<out T>(val data: T) : HomeState<T>()
    data class Error(val exception: Exception) : HomeState<Nothing>()
}
