package com.hazem.eshop.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.hazem.eshop.R
import com.hazem.eshop.domain.model.home.Product
import com.hazem.eshop.presentation.details.component.AddToCartButton
import com.hazem.eshop.presentation.details.component.LowerComponent
import com.hazem.eshop.presentation.details.component.UpperComponent

@Composable

fun DetailsScreen(product: Product, navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {

        UpperComponent(product = product, navController = navController)

        Image(
            modifier = Modifier
                .size(250.dp)
                .align(Alignment.CenterHorizontally),
            painter = rememberAsyncImagePainter(model = product.image),
            contentDescription = stringResource(id = R.string.Product_Image)
        )

        Spacer(
            modifier = Modifier
                .height(50.dp)
                .background(Color(0x8DE7E1E1))
        )



        LowerComponent(product)

        AddToCartButton()
    }

}



