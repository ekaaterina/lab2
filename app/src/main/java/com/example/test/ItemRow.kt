package com.example.test

import android.util.Log
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.clickable
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.test.navigation.Screens


@Composable
fun ItemRow(item: ItemRowModel, navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(30.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(Screens.Hero.itemId(item.id.toString()))
                    Log.i("MyLog", item.id.toString())
                },
            shape = RoundedCornerShape(15.dp),
            elevation = 20.dp
        ) {
            Box(modifier = Modifier.height(500.dp).width(300.dp)) {
                AsyncImage(
                    model = item.url,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    contentDescription = null

                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    Alignment.BottomStart
                ) {
                    Text(text = item.title, style = TextStyle(Color.White, fontSize = 30.sp))
                }
            }
        }
    }
}
