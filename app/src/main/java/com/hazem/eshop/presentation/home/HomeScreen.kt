package com.hazem.eshop.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hazem.eshop.presentation.home.component.ProductItem
import com.hazem.eshop.presentation.home.component.ShowError
import com.hazem.eshop.presentation.home.component.SimpleTopAppBar


@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    val state = homeViewModel.products.value



    Column(modifier = Modifier.fillMaxSize()) {
       SimpleTopAppBar(title = "eShop")


    Box(modifier = Modifier.fillMaxSize()) {
        if (state.products.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(150.dp),
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            ) {

                items(state.products) { product ->
                    ProductItem(product = product)
                }
            }
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colorScheme.primary
            )
        }

        if (state.errorMessage.isNotBlank())
            ShowError(message = state.errorMessage)

    }


}


}