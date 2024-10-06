package com.hazem.eshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.hazem.eshop.domain.model.home.Product
import com.hazem.eshop.presentation.details.DetailsScreen
import com.hazem.eshop.presentation.home.HomeScreen
import com.hazem.eshop.presentation.navigation.CustomNavType
import com.hazem.eshop.presentation.ui.theme.EShopTheme
import com.hazem.eshop.presentation.navigation.Screen
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.typeOf

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen
                    ) {
                        composable<Screen.HomeScreen> {
                            HomeScreen(navController = navController)
                        }
                        composable<Screen.DetailsScreen>(
                            typeMap = mapOf(
                                typeOf<Product>() to CustomNavType.ProductType,

                                )
                        )
                        {
                            val argument = it.toRoute<Screen.DetailsScreen>()
                            DetailsScreen(product = argument.product, navController = navController)
                        }
                    }

                }
            }
        }
    }
}

