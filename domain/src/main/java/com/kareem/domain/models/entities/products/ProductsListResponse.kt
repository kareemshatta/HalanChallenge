package com.kareem.domain.models.entities.products

data class ProductsListResponse(
    var status: String,
    var products: List<Product>
)