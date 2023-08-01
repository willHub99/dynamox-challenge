package com.example.dynamoxchallenge.network.interceptor

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val client: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .build()