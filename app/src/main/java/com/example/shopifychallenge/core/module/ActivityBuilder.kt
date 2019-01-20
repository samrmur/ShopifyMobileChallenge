package com.example.shopifychallenge.core.module

import com.example.shopifychallenge.collections.di.CollectionsFragmentProvider
import com.example.shopifychallenge.core.scope.ActivityScope
import com.example.shopifychallenge.main.di.MainModule
import com.example.shopifychallenge.main.ui.MainActivity
import com.example.shopifychallenge.products.di.ProductsFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [
        MainModule::class,
        CollectionsFragmentProvider::class,
        ProductsFragmentProvider::class
    ])
    @ActivityScope
    abstract fun bindsMainActivity(): MainActivity
}