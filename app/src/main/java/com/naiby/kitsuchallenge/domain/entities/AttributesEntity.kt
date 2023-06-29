package com.naiby.kitsuchallenge.domain.entities



data class AttributesEntity(
    val slug: String,
    val description: String,
    val titles: TitlesEntity,
    val canonicalTitle: String,
    val favoritesCount: Long,
    val startDate: String,
    val averageRating: String,
    val posterImage: PosterImageEntity,
    val coverImage: CoverImageEntity? = null,
    val episodeCount: Long,
    val episodeLength: Long? = null,
    val totalLength: Long,
)
