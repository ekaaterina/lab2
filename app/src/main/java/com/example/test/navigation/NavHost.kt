package com.example.test.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.test.MessageError
import com.example.test.network.getMarvel
import com.example.test.screens.HeroScreen
import com.example.test.screens.MainScreen


sealed class Screens(val route: String) {
    object Main : Screens("main_screen")
    object Hero : Screens("hero_screen")

    fun itemId(vararg args: String): String{
        return buildString{
            append(route)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }
}


@Composable
fun SetupNavHost() {
    val MarvelRow = getMarvel()
    if (MarvelRow[0].title == "error") {
        MessageError()
    } else {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screens.Main.route) {
            composable(route = Screens.Main.route) {
                MainScreen(navController = navController, MarvelRow) }
            composable(route = Screens.Hero.route + "/{id}", arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })) { value ->
                HeroScreen(navController = navController, id = value.arguments?.getInt("id"), MarvelRow)
            }
        }
    }
}

