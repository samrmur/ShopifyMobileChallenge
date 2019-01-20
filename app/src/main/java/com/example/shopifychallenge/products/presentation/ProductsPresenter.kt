package com.example.shopifychallenge.products.presentation

import com.example.shopifychallenge.api.services.ShopifyService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.lang.Exception
import javax.inject.Inject

class ProductsPresenter @Inject constructor(
    private val view: ProductsView,
    private val service: ShopifyService
) {
    fun getProducts(id: Long) {
        view.onStartLoading()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                // Get all product ids
                val body = service.getProductIds(id).await().string()
                val json = JSONObject(body.toString())
                val array = json.getJSONArray("collects")
                val list: ArrayList<Long> = ArrayList()

                // Add all ids to a list
                for (i in 0..(array.length() - 1)) {
                    list.add(array.getJSONObject(i).getLong("product_id"))
                }

                // Put all ids into a string
                val ids = list.joinToString(separator = ",")

                // Get products
                view.onProductsReceived(service.getProducts(ids).await().get)
            } catch (error: Exception) {
                if (error.message.isNullOrBlank())
                    view.onGenericError()
                else
                    view.onError(error.message!!)
            } finally {
                view.onFinishLoading()
            }
        }
    }
}