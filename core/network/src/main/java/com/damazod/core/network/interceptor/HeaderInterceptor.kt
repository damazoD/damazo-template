package com.damazod.core.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("appid", "Damazo template")
                .addHeader("deviceplatform", "android")
                .build()
        )
    }
}