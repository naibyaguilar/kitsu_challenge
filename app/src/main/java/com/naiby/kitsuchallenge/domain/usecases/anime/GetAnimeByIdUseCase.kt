package com.naiby.kitsuchallenge.domain.usecases.anime

import com.naiby.kitsuchallenge.domain.entities.AnimeEntity
import com.naiby.kitsuchallenge.domain.repositories.AnimeRepository
import com.naiby.kitsuchallenge.domain.usecases.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetAnimeByIdUseCase @Inject constructor(
    private val repository: AnimeRepository,
    background : CoroutineDispatcher
) : UseCase<AnimeEntity, String>(background) {
    override suspend fun run(input: String?): AnimeEntity {
        requireNotNull(input){"Anime ID can't be Null"}
        return repository.getAnimeById(input)
    }
}