package com.damazod.core.network.interceptor

import com.damazod.appreversed.ApiData
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

internal class HeaderInterceptor @Inject constructor(
    private val apiData: ApiData
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("x-api-key", apiData.apiKey)
                .build()
        )
    }
}