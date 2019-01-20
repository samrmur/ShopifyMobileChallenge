package com.example.shopifychallenge.api.models

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class CustomProduct(
    val id: Long,
    val title: String,
    @Json(name ="body_html") val body: String,
    val vendor: String,
    val tags: String,
    val variants: List<ProductVariant>,
    val image: ProductImage,
    @Json(name = "product_type") val productType: String,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
    @Json(name = "published_at") val publishedAt: String
)