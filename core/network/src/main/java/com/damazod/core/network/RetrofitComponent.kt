package com.damazod.core.network

import com.damazod.appreversed.BaseUrl
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
    fun getRetrofit(okHttpClient: OkHttpClient, apiBaseUrl: BaseUrl): Retrofit{
        val contentType = "application/json".toMediaType()
        val convertFactory = Json.asConverterFactory(contentType)

        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(convertFactory)
            .baseUrl(apiBaseUrl.value)
            .build()
    }
}