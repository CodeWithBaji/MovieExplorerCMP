package com.moviewexplorer.app.features.home.defaults.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
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
import com.moviewexplorer.app.core.designsystem.ui.defaults.BannerDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.utils.toYear
import com.moviewexplorer.app.domain.model.Movie

@Composable
fun HomeBanner(
    movie: Movie,
    onDetailsScreen: (id: Int) -> Unit
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val backgroundColor = AppColors.Background



    val isLightTheme = AppColors.Background.luminance() > 0.5f

    val bannerPrimaryText =
        if (isLightTheme) Color.White else AppColors.TextPrimary

    val bannerSecondaryText =
        if (isLightTheme) {
            Color.White.copy(alpha = 0.85f)
        } else {
            AppColors.TextSecondary
        }


    val bannerSecondaryButtonText =
        if (isLightTheme) {
            Color(0xFF17181C)
        } else {
            Color.White
        }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
            .clipToBounds()
    ) {

        AsyncImage(
            model = movie.backdropPath,
            contentDescription = movie.originalTitle,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.80f)
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        colors = if (isLightTheme) {
                            listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.15f),
                                Color.Black.copy(alpha = 0.35f),
                                Color.Black.copy(alpha = 0.55f),
                                Color.Black.copy(alpha = 0.78f),
                                Color.Black.copy(alpha = 0.92f)
                            )
                        } else {
                            // Keep Dark theme exactly as it is
                            listOf(
                                Color.Transparent,
                                AppColors.Background.copy(alpha = 0.20f),
                                AppColors.Background.copy(alpha = 0.40f),
                                AppColors.Background.copy(alpha = 0.60f),
                                AppColors.Background.copy(alpha = 0.80f),
                                AppColors.Background
                            )
                        }
                    )
                )
        )

        Column(
            modifier = Modifier
                .widthIn(
                    max = BannerDefaults.contentWidth(windowType)
                )
                .padding(
                    start = dimens.screenPadding,
                    end = dimens.screenPadding,
                    top = dimens.screenPadding,
                    bottom = dimens.sectionSpacing
                )
                .align(Alignment.BottomStart)
        ){

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "FEATURED",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontFamily = MontserratFontFamily(),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = dimens.captionFont,
                        color = AppColors.TextPrimary
                    ),
                    modifier = Modifier
                        .background(
                            AppColors.Primary,
                            RoundedCornerShape(dimens.cornerSmall)
                        )
                        .padding(
                            vertical = dimens.itemSpacing / 4,
                            horizontal = dimens.itemSpacing / 2
                        )
                )

                SpacerHorizontal(dimens.itemSpacing)

                Text(
                    text = movie.releaseDate.toYear(),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontFamily = MontserratFontFamily(),
                        fontSize = dimens.captionFont,
                        fontWeight = FontWeight.Medium,
                        color = bannerSecondaryText
                    )
                )

                SpacerHorizontal(dimens.itemSpacing)

                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xFFFFD250),
                    modifier = Modifier.size(15.dp)
                )

                SpacerHorizontal(dimens.itemSpacing / 2)

                Text(
                    text = "8.7",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontFamily = MontserratFontFamily(),
                        fontSize = dimens.captionFont,
                        fontWeight = FontWeight.Medium,
                        color = bannerSecondaryText
                    )
                )
            }

            SpaceVertical(dimens.itemSpacing)

            Text(
                text = movie.originalTitle,
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontFamily = BebasNeueFontFamily(),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Normal,
                    color = bannerPrimaryText
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            SpaceVertical(dimens.itemSpacing)

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(
                    dimens.itemSpacing / 2
                )
            ) {
                items(movie.genres) { genre ->
                    GenreItem(genre)
                }
            }

            SpaceVertical(dimens.itemSpacing)

            Text(
                text = movie.overview,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = MontserratFontFamily(),
                    fontWeight = FontWeight.Medium,
                    fontSize = dimens.bodyFont,
                    color = bannerSecondaryText
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            SpaceVertical(dimens.sectionSpacing / 2)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    dimens.itemSpacing
                )
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(dimens.searchBarHeight)
                        .clip(
                            RoundedCornerShape(dimens.cornerMedium)
                        )
                        .background(AppColors.Primary)
                        .clickable {
                            // Watch now
                        },
                    contentAlignment = Alignment.Center
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = bannerPrimaryText
                        )

                        SpacerHorizontal(dimens.itemSpacing / 2)

                        Text(
                            text = "Watch Now",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontFamily = MontserratFontFamily(),
                                fontSize = dimens.bodyFont,
                                fontWeight = FontWeight.SemiBold,
                                color = bannerPrimaryText
                            )
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(dimens.searchBarHeight)
                        .clip(
                            RoundedCornerShape(dimens.cornerMedium)
                        )
                        .background(
                            AppColors.Surface.copy(alpha = 0.90f)
                        )
                        .border(
                            width = 1.dp,
                            color = Color.White.copy(alpha = 0.18f),
                            shape = RoundedCornerShape(
                                dimens.cornerMedium
                            )
                        )
                        .clickable {
                            onDetailsScreen(movie.id)
                        },
                    contentAlignment = Alignment.Center
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = null,
                            tint = bannerSecondaryButtonText
                        )

                        SpacerHorizontal(dimens.itemSpacing / 2)

                        Text(
                            text = "Details",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontFamily = MontserratFontFamily(),
                                fontSize = dimens.bodyFont,
                                fontWeight = FontWeight.SemiBold,
                                color = bannerSecondaryButtonText
                            )
                        )
                    }
                }
            }
        }
    }
}