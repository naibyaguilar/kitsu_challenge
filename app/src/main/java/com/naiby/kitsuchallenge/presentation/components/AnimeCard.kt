package com.naiby.kitsuchallenge.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.naiby.kitsuchallenge.domain.entities.AnimeEntity

@Composable
fun AnimeCard(animeEntity: AnimeEntity, onNavigateToDetailAnime: (String) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            ),
        border= BorderStroke(1.dp, Color.White),
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .width(intrinsicSize = IntrinsicSize.Min)
            .clickable { onNavigateToDetailAnime(animeEntity.id) }
    ) {
        ContentCard(animeEntity = animeEntity, onNavigateToDetailAnime = onNavigateToDetailAnime)
    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun ContentCard(animeEntity: AnimeEntity, onNavigateToDetailAnime: (String) -> Unit) {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(5.dp)
        ) {
            GlideImage(
                modifier = Modifier.width(250.dp),
                model = animeEntity.attributes.posterImage.medium,
                contentDescription = null

            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = animeEntity.attributes.canonicalTitle,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Text(text = animeEntity.attributes.startDate,  color = MaterialTheme.colorScheme.secondary,)

        }
    }

}
