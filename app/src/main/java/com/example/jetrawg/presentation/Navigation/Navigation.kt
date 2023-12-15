package com.example.jetrawg.presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetrawg.presentation.Screen.Detail.DetailScreen
import com.example.jetrawg.presentation.Screen.Favorite.FavoriteScreen
import com.example.jetrawg.presentation.Screen.Home.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navHostController = navController)
        }
        composable(Screen.Detail.route) {
            val gameId = navController.previousBackStackEntry?.savedStateHandle?.get<Int>("gameId")
            DetailScreen(gameId, navController)
        }
        composable(Screen.Favorite.route) {
            // Gantilah dengan komposisi untuk FavoriteScreen
            FavoriteScreen(navController = navController)
        }

    }
}