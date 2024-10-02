package com.hazem.eshop.presentation.home

import com.hazem.eshop.domain.model.home.Product

data class ProductsState(
    val products: List<Product> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = false
)
