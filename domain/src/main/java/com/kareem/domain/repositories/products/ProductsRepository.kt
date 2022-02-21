package com.kareem.domain.repositories.products

import com.kareem.domain.models.entities.LoginResponse
import com.kareem.domain.models.entities.products.ProductsListResponse
import com.kareem.domain.models.inputs.LoginInput

interface ProductsRepository {
    suspend fun getProductsList(token: String): ProductsListResponse
}