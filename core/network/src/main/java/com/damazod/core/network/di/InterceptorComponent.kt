package com.damazod.core.network.di

import com.damazod.appreversed.ApiData
import com.damazod.core.network.interceptor.HeaderInterceptor
import com.damazod.core.network.interceptor.InterceptorContainer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object InterceptorComponent {

    @Provides
    fun getOkHttpInterceptor(apiApiData: ApiData): InterceptorContainer {
        return InterceptorContainer(
            applicationInterceptors = listOf(
                HeaderInterceptor(apiApiData)
            ),
            networkInterceptors = emptyList()
        )
    }
}