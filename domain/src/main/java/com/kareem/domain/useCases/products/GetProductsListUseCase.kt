package com.kareem.domain.useCases.products

import com.kareem.domain.models.entities.products.ProductsListResponse
import com.kareem.domain.repositories.products.ProductsRepository
import com.kareem.domain.result.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class GetProductsListUseCase @Inject constructor(
    private val repository: ProductsRepository
) {
    operator fun invoke(token: String): Flow<Resource<ProductsListResponse>> = flow {
        try {
            emit(Resource.Loading())
            val productsListResponse = repository.getProductsList(token)
            emit(Resource.Success(productsListResponse))
        } catch (e: Exception) {
            if (e !is CancellationException) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
            }
        }
    }
}