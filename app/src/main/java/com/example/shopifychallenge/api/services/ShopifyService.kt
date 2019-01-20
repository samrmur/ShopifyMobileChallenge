package com.example.shopifychallenge.api.services

import com.example.shopifychallenge.api.models.Collections
import com.example.shopifychallenge.api.models.Products
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface ShopifyService {
    @GET("custom_collections.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    fun getCollections(): Deferred<Collections>

    @GET("collects.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    fun getProductIds(@Query("collection_id") id: Long): Deferred<ResponseBody>

    @GET("products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    fun getProducts(@Query("ids") ids: String): Deferred<Products>
}
