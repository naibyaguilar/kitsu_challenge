package com.naiby.kitsuchallenge.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TitlesDto (
    val en: String? = null,
    @get:Json(name = "en_jp") val enJp: String?  = null,
    @get:Json(name = "ja_jp") val jaJp: String?  = null,
    @get:Json(name = "en_us") val enUs: String? = null
)
