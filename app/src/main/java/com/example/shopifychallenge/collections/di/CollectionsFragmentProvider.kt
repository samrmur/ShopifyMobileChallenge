package com.example.shopifychallenge.collections.di

import com.example.shopifychallenge.collections.ui.CollectionsFragment
import com.example.shopifychallenge.core.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CollectionsFragmentProvider {
    @ContributesAndroidInjector(modules = [
        CollectionsFragmentModule::class
    ])
    @FragmentScope
    abstract fun providesCollectionsFragment(): CollectionsFragment
}