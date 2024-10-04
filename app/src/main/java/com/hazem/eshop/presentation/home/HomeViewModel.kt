package com.hazem.eshop.presentation.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.eshop.domain.use_case.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {
    private val _products = mutableStateOf(ProductsState())
    val products: State<ProductsState> = _products

    init {
        fetchAllProducts()
    }

    private fun fetchAllProducts() {
        viewModelScope.launch {
            _products.value = ProductsState(isLoading = true)
            homeUseCase().let { result ->

                when (result.success) {
                    true -> {
                        _products.value = ProductsState(isLoading = false)
                        _products.value = ProductsState(products = result.products)
                        Log.d("hhhh", result.products.first().toString())
                    }

                    false -> {
                        _products.value = ProductsState(isLoading = false)
                        _products.value = ProductsState(errorMessage = result.message ?: "Error")
                        Log.d("hhhh", result.message.toString())
                    }
                }
            }


        }

    }

}