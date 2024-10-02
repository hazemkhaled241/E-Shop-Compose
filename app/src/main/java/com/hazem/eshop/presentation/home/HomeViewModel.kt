package com.hazem.eshop.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.eshop.domain.use_case.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {
    private val _products = MutableStateFlow<ProductsState>(ProductsState(isLoading = true))
    val products: StateFlow<ProductsState> get() = _products

    init {
        fetchAllProducts()
    }
    private fun fetchAllProducts() {
        viewModelScope.launch {

            val result = homeUseCase.getAllProducts()

            if (result.success){
                _products.value = ProductsState(isLoading = false)
                _products.value = ProductsState(products = result.products)
                Log.d("hhhh", result.products.first().toString())
            }
            else {
                _products.value = ProductsState(isLoading = false)
                _products.value = ProductsState(errorMessage = result.message ?: "Error")
                Log.d("hhhh", result.message.toString())
            }
        }

    }

}