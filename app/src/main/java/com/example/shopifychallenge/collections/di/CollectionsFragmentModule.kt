package com.example.shopifychallenge.collections.di

import androidx.lifecycle.Lifecycle
import com.example.shopifychallenge.collections.presentation.CollectionsView
import com.example.shopifychallenge.collections.ui.CollectionsFragment
import com.example.shopifychallenge.core.scope.FragmentScope
import com.example.shopifychallenge.util.coroutines.LifecycleScope
import dagger.Module
import dagger.Provides

@Module
class CollectionsFragmentModule {
    @Provides
    @FragmentScope
    fun providesCollectionsView(fragment: CollectionsFragment): CollectionsView = fragment

    @Provides
    @FragmentScope
    fun providesLifecycle(fragment: CollectionsFragment): Lifecycle = fragment.lifecycle

    @Provides
    @FragmentScope
    fun providesLifecycleScope(): LifecycleScope = LifecycleScope()
}