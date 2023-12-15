package com.example.jetrawg.presentation.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.jetrawg.data.network.model.GameDetails
import com.example.jetrawg.data.network.model.ResultsItem

@Composable
fun GamesCard(game: ResultsItem, onCLick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .clickable { onCLick() }
    ) {
        Row {
            Image(
                painter = rememberAsyncImagePainter(model = game.backgroundImage),
                contentDescription = game.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(150.dp)
                    .height(100.dp)
                    .padding(8.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.Start) {
                Text(
                    text = game.name ?: "No Name",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(top = 7.dp)
                )
                Text(
                    text = "Release date ${game.released} ",
                    modifier = Modifier.padding(top = 4.dp)
                )
                Row (verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color(0xFFfca103))
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(text = game.rating.toString(), modifier = Modifier.padding(top = 4.dp))
                }
            }
        }
    }
}

@Composable
fun GamesCardFavorite(game: GameDetails, onCLick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .clickable { onCLick() }
    ) {
        Row {
            Image(
                painter = rememberAsyncImagePainter(model = game.backgroundImage),
                contentDescription = game.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(150.dp)
                    .height(100.dp)
                    .padding(8.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.Start) {
                Text(
                    text = game.name ?: "No Name",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(top = 7.dp)
                )
                Text(
                    text = "Release date ${game.released} ",
                    modifier = Modifier.padding(top = 4.dp)
                )
                Row (verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color(0xFFfca103))
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(text = game.rating.toString(), modifier = Modifier.padding(top = 4.dp))
                }
            }
        }
    }
}