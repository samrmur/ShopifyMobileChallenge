package com.example.shopifychallenge.collections.presentation

import com.example.shopifychallenge.api.models.CustomCollection
import com.example.shopifychallenge.util.view.LoadingView
import com.example.shopifychallenge.util.view.MessageView

interface CollectionsView: LoadingView, MessageView {
    fun onCollectionsReceived(collections: List<CustomCollection>)
}