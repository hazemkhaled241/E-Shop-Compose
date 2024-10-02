package com.hazem.eshop.data.network

import com.hazem.eshop.domain.model.home.Product
import com.hazem.eshop.utils.Constants.PRODUCTS
import retrofit2.http.GET

interface ApiService {
    @GET(PRODUCTS)
    suspend fun getAllProducts() : List<Product>
}