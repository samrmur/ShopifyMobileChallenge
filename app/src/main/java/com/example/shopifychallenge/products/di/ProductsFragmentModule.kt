package com.example.shopifychallenge.products.di

import com.example.shopifychallenge.core.scope.FragmentScope
import com.example.shopifychallenge.products.presentation.ProductsView
import com.example.shopifychallenge.products.ui.ProductsFragment
import dagger.Module
import dagger.Provides

@Module
class ProductsFragmentModule {
    @Provides
    @FragmentScope
    fun providesProductsView(fragment: ProductsFragment): ProductsView = fragment
}