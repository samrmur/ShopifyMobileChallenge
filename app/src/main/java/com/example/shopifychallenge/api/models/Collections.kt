package com.example.shopifychallenge.api.models

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class Collections(
    @Json(name = "custom_collections") val get: List<CustomCollection>
)