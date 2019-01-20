package com.example.shopifychallenge.core.module

import com.example.shopifychallenge.api.services.ShopifyService
import com.example.shopifychallenge.util.kotshi.ApplicationJsonAdapterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
                .build()
    }

    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
                .add(ApplicationJsonAdapterFactory.INSTANCE)
                .build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://shopicruit.myshopify.com/admin/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(client)
                .build()
    }

    @Singleton
    @Provides
    fun providesShopifyService(retrofit: Retrofit): ShopifyService {
        return retrofit.create(ShopifyService::class.java)
    }
}