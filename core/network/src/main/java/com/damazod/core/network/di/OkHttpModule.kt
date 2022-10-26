package com.damazod.core.network.di

import com.damazod.core.network.interceptor.InterceptorContainer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient

@Module
@InstallIn(SingletonComponent::class)
internal object OkHttpModule {

    @Provides
    fun getOkHttpClient(interceptorContainer: InterceptorContainer): OkHttpClient {
        val builder = OkHttpClient.Builder()
        interceptorContainer.applicationInterceptors.forEach {
            builder.addInterceptor(it)
        }
        interceptorContainer.networkInterceptors.forEach {
            builder.addNetworkInterceptor(it)
        }
        return builder.build()
    }
}