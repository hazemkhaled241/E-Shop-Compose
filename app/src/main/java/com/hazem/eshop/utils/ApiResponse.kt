package com.hazem.eshop.utils

import com.hazem.eshop.domain.model.home.Product

data class ApiResponse(
    val success:Boolean,
    val message:String?=null,
    val products:List<Product> = arrayListOf(),
)
