package com.damazod.core.network.interceptor

import okhttp3.Interceptor

internal data class InterceptorContainer(
    val applicationInterceptors: List<Interceptor> = emptyList(),
    val networkInterceptors: List<Interceptor> = emptyList()
)
