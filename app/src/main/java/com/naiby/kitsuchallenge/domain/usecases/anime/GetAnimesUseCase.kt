package com.naiby.kitsuchallenge.domain.usecases.anime

import com.naiby.kitsuchallenge.domain.entities.AnimeEntity
import com.naiby.kitsuchallenge.domain.repositories.AnimeRepository
import com.naiby.kitsuchallenge.domain.usecases.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetAnimesUseCase @Inject constructor(
    private val repository: AnimeRepository,
    background : CoroutineDispatcher
) : UseCase<List<AnimeEntity>, Unit >(background) {
    override suspend fun run(input: Unit?): List<AnimeEntity> {
        return repository.getAnime()
    }
}