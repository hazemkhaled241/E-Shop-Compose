package com.hazem.eshop.utils

sealed class Screen(val route :String) {
    data object HomeScreen:Screen("home_screen")
    data object DetailsScreen:Screen("details_screen/{productId}"){
        fun passProductId(productId:Int):String{
            return "details_screen/$productId"
        }
    }

}