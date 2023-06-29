package com.naiby.kitsuchallenge.data.models

data class AttributesDto(
    val slug: String,
    val description: String,
    val titles: TitlesDto,
    val canonicalTitle: String,
    val favoritesCount: Long,
    val startDate: String,
    val averageRating: String,
    val posterImage: PosterImageDto,
    val coverImage: CoverImageDto? = null,
    val episodeCount: Long,
    val episodeLength: Long? = null,
    val totalLength: Long,

)
