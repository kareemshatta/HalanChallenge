package com.kareem.domain.models.entities.products


data class Product(
    val brand: String,
    val deal_description: String,
    val id: Int,
    val image: String,
    val images: List<String>,
    val name_ar: String,
    val name_en: String,
    val price: Int
)