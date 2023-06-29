package com.naiby.kitsuchallenge.domain.repositories

import com.naiby.kitsuchallenge.domain.entities.AnimeEntity

interface AnimeRepository {
    suspend fun getAnime() : List<AnimeEntity>
    suspend fun getAnimeById( id: String) : AnimeEntity
}