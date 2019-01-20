package com.example.shopifychallenge.api.models

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class CollectionImage(
    @Json(name = "created_at") val createdAt: String,
    var alt: String? = null,
    val width: Int,
    val height: Int,
    val src: String
)