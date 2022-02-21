package com.kareem.data.remote.dto_models.products

import com.kareem.domain.mapper.Mapper
import com.kareem.domain.models.entities.products.Product

data class ProductDTO(
    val brand: String,
    val deal_description: String,
    val id: Int,
    val image: String,
    val images: List<String>,
    val name_ar: String,
    val name_en: String,
    val price: Int
) : Mapper<ProductDTO, Product> {
    override fun map(from: ProductDTO): Product = Product(
        brand = from.brand,
        deal_description = from.deal_description,
        id = from.id,
        image = from.image,
        images = from.images,
        name_ar = from.name_ar,
        name_en = from.name_en,
        price = from.price
    )
}