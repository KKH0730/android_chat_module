package com.example.base.di

import com.example.base.data.DefaultParamsInterceptor
import com.google.gson.Gson
import com.mycelebs.maibook.di.NetworkGson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

const val X_API_KEY = "x-api-key: tZXZmgGslf3U868aknFji2LT6p0DhgC49OG7yG0g"

private const val TIMEOUT_SECONDS = 45L
private const val BASE_URL = "https://gl07095aue.execute-api.ap-northeast-2.amazonaws.com/prod/"

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideDefaultParamsInterceptor(): DefaultParamsInterceptor = DefaultParamsInterceptor()

    @Singleton
    @Provides
    fun provideOkHttpClient(
        defaultParamsInterceptor: DefaultParamsInterceptor,
    ) = OkHttpClient.Builder()
        .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .addNetworkInterceptor(defaultParamsInterceptor)
        .addNetworkInterceptor(
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        ).build()

    @Singleton
    @Provides
    fun provideRetrofit(@NetworkGson gson: Gson, okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()

}