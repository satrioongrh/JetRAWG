package com.example.jetrawg.presentation.Screen.Home

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.jetrawg.presentation.Component.GamesCard
import com.example.jetrawg.presentation.Component.Searchbar
import com.example.jetrawg.presentation.Navigation.Screen

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val homeState = homeViewModel.games.value
    val searchState = homeViewModel.search.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp)
    ) {
        var searchBarText by remember {
            mutableStateOf("")
        }

        Searchbar(
            value = searchBarText,
            onValueChange = { searchBarText = it },
            onClick = { homeViewModel.doSearchGames(searchBarText) })
        if (searchState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(CenterHorizontally)
            )
        } else if (searchState.error.isNotEmpty()) {
            Text(
                text = "Error: ${searchState.error}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        } else if (searchState.data != null) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(searchState.data!!.results ?: emptyList()) {
                    GamesCard(game = it!!, onCLick = {
                        navHostController.currentBackStackEntry?.savedStateHandle?.set(
                            "gameId",
                            it.id
                        )
                        navHostController.navigate(Screen.Detail.route)
                    })
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                when {
                    homeState.isLoading -> {
                        item {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .align(CenterHorizontally)
                                )
                            }
                        }
                    }

                    homeState.error.isNotEmpty() -> {
                        item {
                            Text(
                                text = "Error: ${homeState.error}",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                        }
                    }

                    homeState.data != null -> {
                        items(homeState.data!!.results ?: emptyList()) {
                            GamesCard(game = it!!, onCLick = {
                                navHostController.currentBackStackEntry?.savedStateHandle?.set(
                                    "gameId",
                                    it.id
                                )
                                navHostController.navigate(Screen.Detail.route)
                            })
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}