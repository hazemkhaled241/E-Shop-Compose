package com.hazem.eshop.presentation.details.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hazem.eshop.domain.model.home.Product

@Composable
fun LowerComponent(product:Product){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0x8DE7E1E1)),

        ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {

            Text(
                text = product.title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )



            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = product.description, fontSize = 16.sp, color = Color.Black
            )
            Spacer(modifier = Modifier.height(20.dp))


        }
    }
}