package com.example.jetrawg.presentation.Navigation

sealed class Screen (val route: String) {

    object Home: Screen("home")
    object Detail: Screen("detail")
    object Favorite: Screen("favorite")

}