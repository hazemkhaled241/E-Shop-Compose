package com.hazem.eshop.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.hazem.eshop.R
import com.hazem.eshop.domain.model.home.Product
import com.hazem.eshop.domain.model.home.Rating

@Composable
fun ProductItem(
    product: Product
) {
    Card(
        modifier = Modifier
            .height(270.dp)
            .width(213.dp)
            .padding(6.dp)
            .clickable {
                //navigate to details screen
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ), shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, end = 15.dp, top = 20.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally),
                painter = rememberAsyncImagePainter(
                    model = product.image
                ), contentDescription = stringResource(
                    R.string.Product_Image
                )
            )
            Text(
                text = product.title, modifier = Modifier.padding(top = 28.dp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium,
                overflow = TextOverflow.Ellipsis,
                fontSize = 15.sp,
                maxLines = 1,
                color = Color.Black

            )
            Text(
                text = product.description, modifier = Modifier.padding(top = 3.dp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp,
                maxLines = 1,
                color = Color.Black

            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${product.price}",
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black,
                    fontSize = 18.sp
                )

                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center

                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = stringResource(
                            R.string.shopping_cart_icon
                        ),
                        tint = Color.White
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun ProductItemPreview() {
    ProductItem(
        product = Product(
            id = 1,
            category = "",
            description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday category: men's clothing",
            image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
            price = 2.1,
            rating = Rating(count = 1, rate = 2.5),
            title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
        )
    )
}