package com.hazem.eshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hazem.eshop.presentation.details.DetailsScreen
import com.hazem.eshop.presentation.home.HomeScreen
import com.hazem.eshop.presentation.ui.theme.EShopTheme
import com.hazem.eshop.utils.Constants.PRODUCT_ID
import com.hazem.eshop.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

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
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(route = Screen.HomeScreen.route) {
                            HomeScreen(navController=navController)
                        }
                        composable(
                            route = Screen.DetailsScreen.route,
                            arguments = listOf(navArgument(PRODUCT_ID) {
                                type = NavType.IntType
                            })
                        ) {
                            DetailsScreen(navController)
                        }
                    }

                }
            }
        }
    }
}

