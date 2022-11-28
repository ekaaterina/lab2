package com.example.test

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@Composable
fun List(MarvelRow: List<ItemRowModel>, navController : NavHostController) {
    LazyRow(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        itemsIndexed(MarvelRow) {index, item ->
            ItemRow(item, MarvelRow.indexOf(item), navController)
                    }

        }
    }
