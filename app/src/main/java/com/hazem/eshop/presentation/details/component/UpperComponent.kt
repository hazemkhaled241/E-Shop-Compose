package com.hazem.eshop.presentation.details.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hazem.eshop.R
import com.hazem.eshop.domain.model.home.Product

@Composable
fun UpperComponent(product:Product,navController:NavHostController){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, start = 15.dp, end = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .background(color = Color(0x8DE7E1E1), shape = CircleShape)
                .clip(CircleShape)
        ) {
            Image(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(R.string.back_icon)
            )
        }

        Row(
            modifier = Modifier
                .width(70.dp)
                .background(
                    color = Color(0x8DE7E1E1), shape = RoundedCornerShape(8.dp)
                )
                .padding(3.dp)
                .clip(RoundedCornerShape(8.dp)),
            horizontalArrangement = Arrangement.spacedBy(
                4.dp,
                alignment = Alignment.CenterHorizontally
            )
            , verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = product.rating.rate.toString(),
                style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold)
            )
            Image(
                imageVector = Icons.Default.Star,
                contentDescription = stringResource(R.string.star_icon)
            )

        }
    }

}