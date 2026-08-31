package com.moviewexplorer.app.features.home.defaults.components.collapsBanner

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.BebasNeueFontFamily
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.utils.toYear
import com.moviewexplorer.app.domain.model.Movie

@Composable
fun CollapsedHomeBanner(
    movie: Movie,
    modifier: Modifier = Modifier,
    onDetailsScreen: (id: Int) -> Unit
) {

    val dimens = LocalAppDimens.current

    Crossfade(
        targetState = movie,
        animationSpec = tween(
            durationMillis = 800,
            easing = FastOutSlowInEasing
        ),
        label = "CollapsedBannerAnimation",
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
    ) { currentMovie ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(AppColors.Background)
                .clickable {
                    onDetailsScreen(currentMovie.id)
                }
                .clipToBounds()
        ) {

            AsyncImage(
                model = currentMovie.backdropPath,
                contentDescription = currentMovie.originalTitle,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                AppColors.Background.copy(alpha = 0.95f),
                                AppColors.Background.copy(alpha = 0.80f),
                                AppColors.Background.copy(alpha = 0.45f),
                                Color.Transparent
                            )
                        )
                    )
            )

            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                AppColors.Background.copy(alpha = 0.25f),
                                AppColors.Background.copy(alpha = 0.60f),
                                AppColors.Background
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .fillMaxWidth(0.70f)
                    .padding(horizontal = dimens.screenPadding)
            ) {

                Text(
                    text = currentMovie.originalTitle,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontFamily = BebasNeueFontFamily(),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Normal,
                        color = AppColors.TextPrimary
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                SpaceVertical(dimens.itemSpacing / 2)

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = currentMovie.releaseDate.toYear(),
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontFamily = MontserratFontFamily(),
                            fontSize = dimens.captionFont,
                            fontWeight = FontWeight.Medium,
                            color = AppColors.TextSecondary
                        )
                    )

                    SpacerHorizontal(dimens.itemSpacing)

                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFD250),
                        modifier = Modifier.size(14.dp)
                    )

                    SpacerHorizontal(dimens.itemSpacing / 2)

                    Text(
                        text = "8.7",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontFamily = MontserratFontFamily(),
                            fontSize = dimens.captionFont,
                            fontWeight = FontWeight.Medium,
                            color = AppColors.TextSecondary
                        )
                    )
                }
            }
        }
    }
}