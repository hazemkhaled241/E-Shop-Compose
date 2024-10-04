package com.hazem.eshop.presentation.home.component

import android.app.Activity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTopAppBar(title: String) {
    val act = LocalContext.current as Activity
    TopAppBar(
        title = { Text(text = title, fontSize = 20.sp) },
        navigationIcon = {
            IconButton(onClick = { act.finish() }) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "menu Icon")
            }

        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            }
            IconButton(onClick = { /* doSomething */ }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
            }

        }

    )
}


@Preview
@Composable
fun SimpleTopAppBarPreview() {
    SimpleTopAppBar(title = "eShop")
}