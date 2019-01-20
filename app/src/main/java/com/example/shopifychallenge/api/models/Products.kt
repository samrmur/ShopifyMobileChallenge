package com.example.shopifychallenge.api.models

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class Products(
    @Json(name = "products") val get: List<CustomProduct>
)