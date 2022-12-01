package com.example.test.screens


import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.test.ItemRowModel


@Composable
fun HeroScreen(navController: NavHostController, id: Int?, MarvelRow: List<ItemRowModel>) {

    AsyncImage(
        model = MarvelRow[id!!].url,
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Box(modifier = Modifier
        .clickable { navController.popBackStack() }
        .padding(10.dp))
    {
        Box(
            modifier = Modifier.fillMaxSize(),
            Alignment.TopStart
        ) {
            TextButton(onClick = {
                Log.e("MyLog", id.toString())
                navController.popBackStack()
            }) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                Alignment.BottomStart
            ) {
                Column() {
                    Text(text = MarvelRow[id].title, style = TextStyle(color = Color.Black, fontSize = 35.sp,))
                    Text(text = MarvelRow[id].hero, style = TextStyle(color = Color.Black, fontSize = 25.sp))
                }
            }
        }
    }
}