package com.naiby.kitsuchallenge.data.mappers

import com.naiby.kitsuchallenge.data.models.*
import com.naiby.kitsuchallenge.domain.entities.*

fun TitlesDto.toEntity() = TitlesEntity(
    en = en,
    enJp = enJp,
    jaJp = jaJp,
    enUs = enUs
)

fun PosterImageDto.toEntity() = PosterImageEntity(
    tiny = tiny,
    large = large,
    small = small,
    medium = medium,
    original = original,
)

fun CoverImageDto.toEntity() = CoverImageEntity(
    tiny = tiny,
    large = large,
    small = small,
    original = original,
)

fun AttributesDto.toEntity() = AttributesEntity(
    slug = slug,
    description = description,
    titles = titles.toEntity(),
    canonicalTitle = canonicalTitle,
    favoritesCount = favoritesCount,
    startDate = startDate,
    averageRating = averageRating,
    posterImage = posterImage.toEntity(),
    coverImage = coverImage?.toEntity(),
    episodeCount = episodeCount,
    episodeLength = episodeLength,
    totalLength = totalLength,
)
fun AnimeDto.toEntity() = AnimeEntity(
    id = id,
    attributes = attributes.toEntity()
)




