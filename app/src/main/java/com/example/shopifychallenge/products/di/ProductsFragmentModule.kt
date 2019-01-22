package com.example.shopifychallenge.products.di

import androidx.lifecycle.Lifecycle
import com.example.shopifychallenge.core.scope.FragmentScope
import com.example.shopifychallenge.products.presentation.ProductsView
import com.example.shopifychallenge.products.ui.ProductsFragment
import com.example.shopifychallenge.util.coroutines.LifecycleScope
import dagger.Module
import dagger.Provides

@Module
class ProductsFragmentModule {
    @Provides
    @FragmentScope
    fun providesProductsView(fragment: ProductsFragment): ProductsView = fragment

    @Provides
    @FragmentScope
    fun providesLifecycle(fragment: ProductsFragment): Lifecycle = fragment.lifecycle

    @Provides
    @FragmentScope
    fun providesLifecycleScope(): LifecycleScope = LifecycleScope()
}