package com.example.shopifychallenge.core

import com.example.shopifychallenge.core.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class ShopifyChallengeApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerApplicationComponent.builder().create(this)

}