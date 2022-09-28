package com.damazod.core.network.di

import com.damazod.appreversed.ApiData
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object RetrofitComponent {

    @Provides
    @ExperimentalSerializationApi
    fun getRetrofit(okHttpClient: OkHttpClient, apiData: ApiData): Retrofit {
        val contentType = "application/json".toMediaType()
        val jsonFormat = Json { ignoreUnknownKeys = true }
        val convertFactory = jsonFormat.asConverterFactory(contentType)

        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(convertFactory)
            .baseUrl(apiData.baseUrl)
            .build()
    }
}