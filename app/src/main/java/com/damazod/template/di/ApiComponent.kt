package com.damazod.template.di

import com.damazod.appreversed.BaseUrl
import com.damazod.template.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiComponent {

    @Singleton
    @Provides
    fun getBaseURL(): BaseUrl {
        return object : BaseUrl {
            override val value: String
                get() = BuildConfig.BASE_URL
        }
    }
}
