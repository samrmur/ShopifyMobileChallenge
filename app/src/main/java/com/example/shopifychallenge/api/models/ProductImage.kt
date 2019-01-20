package com.example.shopifychallenge.api.models

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class ProductImage(
    val id: Long,
    @Json(name = "product_id") val productId: Long,
    val position: Int,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
    val alt: String? = null,
    val width: Int,
    val height: Int,
    val src: String,
    @Json(name = "variant_ids") val variantIds: List<String>
)