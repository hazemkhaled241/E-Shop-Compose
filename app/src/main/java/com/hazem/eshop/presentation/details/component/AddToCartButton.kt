package com.hazem.eshop.presentation.details.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddToCartButton() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White
            ),
            modifier = Modifier
                .width(200.dp)
                .padding(top = 30.dp, bottom = 30.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(15.dp)),
            onClick = {
                //show message
            },
        ) {
            Text(text = "Add to Cart", fontSize = 16.sp)
        }
    }
}
