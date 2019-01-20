package com.example.shopifychallenge.api.models

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class ProductVariant(
    val id: Long,
    @Json(name = "product_id") val productId: Long,
    val title: String,
    val price: String,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
    @Json(name = "inventory_item_id") val inventoryId: String,
    @Json(name = "inventory_quantity") val inventoryCount: Int,
    val taxable: Boolean
)