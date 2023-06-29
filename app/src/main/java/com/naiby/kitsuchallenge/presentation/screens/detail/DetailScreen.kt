package com.naiby.kitsuchallenge.presentation.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.naiby.kitsuchallenge.R
import com.naiby.kitsuchallenge.domain.entities.AnimeEntity
import com.naiby.kitsuchallenge.presentation.components.RatingBar
import com.naiby.kitsuchallenge.presentation.states.DetailState

@Composable
fun DetailScreen(state: DetailState) {
    Surface() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp).verticalScroll(rememberScrollState())
        ) {
            when (state) {
                is DetailState.IsLoading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        LinearProgressIndicator()
                    }
                }

                is DetailState.Success -> {

                    ContentDetail(state.data)
                }

                is DetailState.Error -> {
                    Text(text = "No hay")
                }
            }
        }

    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun ContentDetail(animeEntity: AnimeEntity) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .paint(painterResource(id = R.drawable.kitsu_fox), contentScale = ContentScale.FillWidth),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        GlideImage(
            modifier = Modifier.fillMaxWidth().height(300.dp),
            model = animeEntity.attributes.posterImage.large,
            contentDescription = null

        )
        Text(
            text = animeEntity.attributes.titles.en?:"Not Found",
            fontSize = 30.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
    Text(
        text =animeEntity.attributes.titles.jaJp?:"Not Found",
        fontSize = 20.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        color = MaterialTheme.colorScheme.secondary
    )
    Spacer(modifier = Modifier.height(30.dp))
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.height(intrinsicSize = IntrinsicSize.Min)
    ) {
        Text(
            text = animeEntity.attributes.startDate,
            modifier = Modifier.weight(0.4f),
            fontSize = 17.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
        Divider(
            modifier = Modifier
                .width(1.dp)
                .fillMaxHeight(),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text ="Episodes: ${animeEntity.attributes.episodeCount}" , modifier = Modifier
                .weight(0.5f)
                .padding(horizontal = 16.dp),
            fontSize = 17.sp, fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
        Divider(
            modifier = Modifier
                .width(1.dp)
                .fillMaxHeight(),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.secondary
        )
        RatingBar(rating = animeEntity.attributes.averageRating.toDouble()/20, modifier = Modifier.padding(horizontal = 5.dp))
    }
    Spacer(modifier = Modifier.height(30.dp))
    Text(
        text = "Description",
        fontSize = 20.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.tertiary

    )
    Text(
        text = animeEntity.attributes.description,
        fontSize = 20.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Justify
    )
    Spacer(modifier = Modifier.height(20.dp))
    GlideImage(
        model = animeEntity.attributes.coverImage?.large,
        contentDescription = null

    )

}
