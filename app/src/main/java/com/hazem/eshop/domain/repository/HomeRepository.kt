package com.hazem.eshop.domain.repository

import com.hazem.eshop.utils.ApiResponse

interface HomeRepository {

   suspend fun  getAllProducts(): ApiResponse
}