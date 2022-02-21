package com.kareem.data.repositories_imp.products

import com.kareem.data.remote.ApiInterface
import com.kareem.domain.models.entities.LoginResponse
import com.kareem.domain.models.entities.products.ProductsListResponse
import com.kareem.domain.models.inputs.LoginInput
import com.kareem.domain.repositories.auth.AuthRepository
import com.kareem.domain.repositories.products.ProductsRepository
import org.json.JSONObject
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val service: ApiInterface
) : ProductsRepository {

    override suspend fun getProductsList(token: String): ProductsListResponse {
        val response = service.getProductsList("Bearer $token")
        if (response.isSuccessful) {
            return response.body()!!.map(response.body()!!)
        } else {
            val jsonObject = JSONObject(response.errorBody()?.string())
            val errorMessage = jsonObject.get("message").toString()
            throw Exception(errorMessage)
        }
    }
}