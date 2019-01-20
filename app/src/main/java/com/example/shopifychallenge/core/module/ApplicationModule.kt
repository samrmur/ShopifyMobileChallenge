package com.example.shopifychallenge.core.module

import com.example.shopifychallenge.core.ShopifyChallengeApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {
    @Provides
    fun providesApplicationContext(application: ShopifyChallengeApplication) = application.applicationContext
}