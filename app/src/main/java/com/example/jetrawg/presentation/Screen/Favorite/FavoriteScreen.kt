package com.example.jetrawg.presentation.Screen.Favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.jetrawg.presentation.Component.GamesCardFavorite
import com.example.jetrawg.presentation.Navigation.Screen

@Composable
fun FavoriteScreen(navController: NavHostController, favoriteViewModel: FavoriteViewModel = hiltViewModel()) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(14.dp)) {
        when {
            favoriteViewModel.state.value.isLoading -> {
                item {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }

            favoriteViewModel.state.value.error.isNotEmpty() -> {
                item {
                    Text(
                        text = "Error: ${favoriteViewModel.state.value.error}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }

            favoriteViewModel.state.value.favorites.isNotEmpty() != null -> {
                items(favoriteViewModel.state.value.favorites) {
                    GamesCardFavorite(game = it) {
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            "gameId",
                            it.id
                        )
                        navController.navigate(Screen.Detail.route)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}