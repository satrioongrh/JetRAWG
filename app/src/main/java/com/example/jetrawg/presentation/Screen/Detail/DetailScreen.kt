package com.example.jetrawg.presentation.Screen.Detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun DetailScreen(
    id: Int? = null,
    navController: NavController,
    detailViewModel: DetailViewModel = hiltViewModel()
) {
    LaunchedEffect(id) {
        id?.let {
            detailViewModel.getGameDetail(it)
            detailViewModel.isFavorite(gameId = it)
        }
    }


    val scrool = rememberScrollState()

    var isFavoriteState by remember { mutableStateOf(detailViewModel.detailGames.value.isFavorite) }
    Log.d("dlwoa", "DetailScreen: ${isFavoriteState}")

    LaunchedEffect(detailViewModel.detailGames.value.isFavorite) {
        isFavoriteState = detailViewModel.detailGames.value.isFavorite
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val detailResult = detailViewModel.detailGames.value
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back", modifier = Modifier.clickable {
                navController.navigateUp()
            })
            Text(text = "Detail", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
            val favoriteIcon = if (isFavoriteState == true) {
                Icons.Default.Favorite
            } else {
                Icons.Rounded.FavoriteBorder
            }
            Icon(
                imageVector = favoriteIcon,
                contentDescription = "favorite",
                modifier = Modifier
                    .clickable {
                        isFavoriteState = !isFavoriteState

                        detailViewModel.detailGames.value.data?.let {
                            Log.d("kkao", "DetailScreen: ${it}")
                            detailViewModel.addToFavorites(it)
                        }
                    }
            )

        }
        when {
            detailResult.isLoading -> {
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

            detailResult.error.isNotEmpty() -> {
                Text(
                    text = "Error: ${detailResult.error}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

            detailResult.data != null -> {

                Image(
                    painter = rememberAsyncImagePainter(model = detailResult.data!!.backgroundImage),
                    contentDescription = detailResult.data!!.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .verticalScroll(scrool)
                ) {
                    Text(
                        text = detailResult.data!!.name.toString(),
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = detailResult.data!!.name.toString(),
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Release date ${detailResult.data!!.released}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFfca103)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = detailResult.data!!.rating.toString(),
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = detailResult.data!!.description.toString(),
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Justify
                        )
                    )
                }
            }
        }
    }
}