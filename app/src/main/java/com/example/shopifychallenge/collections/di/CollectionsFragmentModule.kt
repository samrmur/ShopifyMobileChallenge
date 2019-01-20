package com.example.shopifychallenge.collections.di

import com.example.shopifychallenge.collections.presentation.CollectionsView
import com.example.shopifychallenge.collections.ui.CollectionsFragment
import com.example.shopifychallenge.core.scope.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class CollectionsFragmentModule {
    @Provides
    @FragmentScope
    fun providesCollectionsView(fragment: CollectionsFragment): CollectionsView = fragment
}