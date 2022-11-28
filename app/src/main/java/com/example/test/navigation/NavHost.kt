package com.example.test.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.test.screens.HeroScreen
import com.example.test.screens.MainScreen


const val ID = "id"
sealed class Screens(val route: String){
    object Main: Screens("main_screen")
    object Hero: Screens("hero_screen/{$ID}"){
        fun passId(id:Int):String{
            return "hero_screen/$id"
        }
    }

}


@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Main.route) {
        composable(route = Screens.Main.route) {
            MainScreen(navController)
        }
        composable(route = Screens.Hero.route, arguments = listOf(navArgument(ID) {
            type = NavType.IntType
        })) {
            HeroScreen(navController, it.arguments?.getInt(ID) ?: 0)

        }
    }
}

