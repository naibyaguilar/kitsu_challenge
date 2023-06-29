package com.naiby.kitsuchallenge.presentation.screens.home

import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.naiby.kitsuchallenge.R
import com.naiby.kitsuchallenge.domain.entities.AnimeEntity
import com.naiby.kitsuchallenge.presentation.components.AnimeCard
import com.naiby.kitsuchallenge.presentation.states.HomeState

@Composable
fun HomeScreen(state: HomeState<List<AnimeEntity>>, onNavigateToDetailAnime : (String)-> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize()

    ) {
        when (state) {
            is HomeState.IsLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    LinearProgressIndicator()
                }
            }

            is HomeState.Success -> {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        modifier = Modifier.height(50.dp),
                        painter = painterResource(id = R.drawable.kitsu),
                        contentDescription = stringResource(id = R.string.app_name)
                    )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    items(state.data) {
                        AnimeCard(animeEntity=it, onNavigateToDetailAnime = onNavigateToDetailAnime)
                    }
                }
                }
            }

            is HomeState.Error -> {
                Text(text = "Not Found")

            }
        }
    }

}