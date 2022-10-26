package com.damazod.template.di

import com.damazod.appreversed.ApiData
import com.damazod.template.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiDataModule {

    @Singleton
    @Provides
    fun getBaseURL(): ApiData {
        return object : ApiData {
            override val baseUrl: String
                get() = BuildConfig.BASE_URL
            override val apiKey: String
                get() = BuildConfig.API_KEY
        }
    }
}
