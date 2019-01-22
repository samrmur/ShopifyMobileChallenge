package com.example.shopifychallenge.collections.presentation

import androidx.lifecycle.Lifecycle
import com.example.shopifychallenge.api.services.ShopifyService
import com.example.shopifychallenge.main.presentation.MainNavigator
import com.example.shopifychallenge.util.coroutines.LifecycleScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class CollectionsPresenter @Inject constructor(
    private val service: ShopifyService,
    private val view: CollectionsView,
    lifecycle: Lifecycle,
    private val scope: LifecycleScope,
    private val navigator: MainNavigator
) {
    init {
        lifecycle.addObserver(scope)
    }

    fun getCollections() {
        view.onStartLoading()

        scope.launch {
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