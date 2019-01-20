package com.example.shopifychallenge.products.presentation

import com.example.shopifychallenge.api.models.CustomProduct
import com.example.shopifychallenge.util.view.LoadingView
import com.example.shopifychallenge.util.view.MessageView

interface ProductsView: LoadingView, MessageView {
    fun onProductsReceived(products: List<CustomProduct>)
}