package com.hazem.eshop.data.repository

import android.net.ConnectivityManager
import com.hazem.eshop.data.network.ApiService
import com.hazem.eshop.utils.ApiResponse
import com.hazem.eshop.domain.repository.HomeRepository
import com.hazem.eshop.utils.checkInternetConnection
import javax.inject.Inject

class HomeRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val connectivityManager: ConnectivityManager
) : HomeRepository {
    override suspend fun getAllProducts(): ApiResponse {
        return if (connectivityManager.checkInternetConnection()){
            try {
                ApiResponse(success = true, products = apiService.getAllProducts())
            } catch (e: Exception) {
                ApiResponse(success = false, message = e.localizedMessage)
            }
        }

        else {
            ApiResponse(success = false, message = "No Internet Connection")

        }

    }
}