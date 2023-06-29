package com.naiby.kitsuchallenge.data.repositories

import com.naiby.kitsuchallenge.data.mappers.toEntity
import com.naiby.kitsuchallenge.data.remote.api.AnimeService
import com.naiby.kitsuchallenge.domain.entities.AnimeEntity
import com.naiby.kitsuchallenge.domain.repositories.AnimeRepository
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val animeService: AnimeService
) : AnimeRepository {
    override suspend fun getAnime() : List<AnimeEntity>{

        return animeService.getAnimeList().data.map { animeDto-> animeDto.toEntity() }
    }

    override suspend fun getAnimeById(id: String) : AnimeEntity {
        return animeService.getAnimeById(id).data.toEntity()
    }


}