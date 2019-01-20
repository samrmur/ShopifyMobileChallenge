package com.example.shopifychallenge.main.di

import com.example.shopifychallenge.core.scope.ActivityScope
import com.example.shopifychallenge.main.presentation.MainNavigator
import com.example.shopifychallenge.main.ui.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    @ActivityScope
    fun providesNavigator(activity: MainActivity): MainNavigator = MainNavigator(activity)
}