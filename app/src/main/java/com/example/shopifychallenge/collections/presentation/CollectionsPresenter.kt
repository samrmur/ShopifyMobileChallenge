package com.example.shopifychallenge.collections.presentation

import com.example.shopifychallenge.api.services.ShopifyService
import com.example.shopifychallenge.main.presentation.MainNavigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class CollectionsPresenter @Inject constructor(
    private val service: ShopifyService,
    private val view: CollectionsView,
    private val navigator: MainNavigator
) {
    fun getCollections() {
        view.onStartLoading()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                view.onCollectionsReceived(service.getCollections().await().get)
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

    fun toProducts(
        id: Long,
        title: String,
        body: String,
        publishedAt: String,
        updatedAt: String,
        imageSrc: String
    ) {
        navigator.toProducts(id, title, body, publishedAt, updatedAt, imageSrc)
    }
}