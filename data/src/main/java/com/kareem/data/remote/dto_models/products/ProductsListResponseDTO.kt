package com.kareem.data.remote.dto_models.products

import com.kareem.domain.mapper.Mapper
import com.kareem.domain.models.entities.products.ProductsListResponse

data class ProductsListResponseDTO(
    var status: String,
    var products: List<ProductDTO>
) : Mapper<ProductsListResponseDTO, ProductsListResponse> {
    override fun map(from: ProductsListResponseDTO): ProductsListResponse = ProductsListResponse(
        status = from.status,
        products = from.products.map { it.map(it) }
    )
}