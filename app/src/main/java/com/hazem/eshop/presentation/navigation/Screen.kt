package com.hazem.eshop.presentation.navigation

import com.hazem.eshop.domain.model.home.Product
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(val route :String) {
    @Serializable
    data object HomeScreen
    @Serializable
    data class DetailsScreen(val product: Product)

}