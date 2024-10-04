package com.hazem.eshop.domain.use_case

import com.hazem.eshop.utils.ApiResponse
import com.hazem.eshop.domain.repository.HomeRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {

   suspend operator fun  invoke(): ApiResponse {
       return homeRepository.getAllProducts()
   }
}