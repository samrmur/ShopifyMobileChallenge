package com.example.shopifychallenge.core.component

import com.example.shopifychallenge.core.ShopifyChallengeApplication
import com.example.shopifychallenge.core.module.ActivityBuilder
import com.example.shopifychallenge.core.module.ApplicationModule
import com.example.shopifychallenge.core.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuilder::class,
    ApplicationModule::class,
    NetworkModule::class
])
interface ApplicationComponent: AndroidInjector<ShopifyChallengeApplication> {
    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<ShopifyChallengeApplication>()
}