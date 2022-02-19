package com.kareem.data.remote

import com.kareem.data.remote.dto_models.LoginResponseDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("auth")
    suspend fun login(
        @Body body: Map<String, String>
    ): Response<LoginResponseDTO>
}