package com.naiby.kitsuchallenge.data.remote.api

import com.naiby.kitsuchallenge.data.models.AnimeDto
import com.naiby.kitsuchallenge.data.models.base.Envelop
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeService {

    @GET("anime/")
    suspend fun getAnimeList(): Envelop<List<AnimeDto>>

    @GET("anime/{id}")
    suspend fun getAnimeById(
        @Path("id") id : String
    ): Envelop<AnimeDto>

}