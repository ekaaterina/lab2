package com.example.test.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material.Text
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
import com.example.test.Hero



@Composable
fun HeroScreen(navController: NavHostController, index:Int) {

    val item = Hero.Heroes[index]

        AsyncImage(
            model = item.url,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Box(modifier = Modifier
            .clickable { navController.popBackStack() }
            .padding(10.dp))
        {
            Icon(
                Icons.Rounded.ArrowBack,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(30.dp)
            )}
            Box(modifier = Modifier.fillMaxSize(),
                Alignment.BottomStart) {
                Column() {
                    Text(text = item.title, style = TextStyle(Color.White, fontSize = 35.sp))

                    Text(text = item.hero, style = TextStyle(color = Color.White, fontSize = 25.sp)
                    )
                }
            }
    }
//}