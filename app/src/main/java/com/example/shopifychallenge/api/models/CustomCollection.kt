package com.example.shopifychallenge.api.models

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class CustomCollection(
    val id: Long,
    val title: String,
    @Json(name ="body_html") val body: String,
    @Json(name ="published_at") val publishedAt: String,
    @Json(name ="updated_at") val updatedAt: String,
    val image: CollectionImage
)