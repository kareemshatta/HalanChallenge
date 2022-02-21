package com.kareem.data.remote

import com.kareem.data.remote.dto_models.auth.LoginResponseDTO
import com.kareem.data.remote.dto_models.products.ProductsListResponseDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiInterface {
    @POST("auth")
    suspend fun login(
        @Body body: Map<String, String>
    ): Response<LoginResponseDTO>

    @GET("products")
    suspend fun getProductsList(
        @Header("Authorization") token: String
    ): Response<ProductsListResponseDTO>
}