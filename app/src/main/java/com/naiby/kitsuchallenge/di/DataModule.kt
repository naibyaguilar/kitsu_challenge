package com.naiby.kitsuchallenge.di

import com.naiby.kitsuchallenge.data.repositories.AnimeRepositoryImpl
import com.naiby.kitsuchallenge.domain.repositories.AnimeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindAnimeRepository( animeRepositoryImpl: AnimeRepositoryImpl) : AnimeRepository

}