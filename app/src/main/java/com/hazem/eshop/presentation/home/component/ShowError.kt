package com.hazem.eshop.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hazem.eshop.R

@Composable
fun ShowError(
    message: String,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_error_24),
                contentDescription = stringResource(R.string.error_image),
                alignment = Alignment.Center,
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = message,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}

@Preview
@Composable
fun ShowErrorPreview() {
    ShowError(message = "No Internet Connection")
}