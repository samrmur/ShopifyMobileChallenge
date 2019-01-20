package com.example.shopifychallenge.products.di

import com.example.shopifychallenge.core.scope.FragmentScope
import com.example.shopifychallenge.products.ui.ProductsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProductsFragmentProvider {
    @ContributesAndroidInjector(modules = [
        ProductsFragmentModule::class
    ])
    @FragmentScope
    abstract fun providesProductsFragment(): ProductsFragment
}
