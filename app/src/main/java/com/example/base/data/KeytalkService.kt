package com.example.base.data

import com.example.base.di.X_API_KEY
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface KeytalkService {

    @Headers(X_API_KEY)
    @POST("keytalk_list/{vertical}")
    suspend fun keytalkList(@Path("vertical") vertical: String): KeytalkListResponse
}