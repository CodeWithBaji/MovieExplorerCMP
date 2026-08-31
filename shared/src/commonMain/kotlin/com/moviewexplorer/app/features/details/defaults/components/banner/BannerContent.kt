package com.moviewexplorer.app.features.details.defaults.components.banner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import com.moviewexplorer.app.features.home.defaults.components.GenreItem

@Composable
fun BannerContent(
    movie: Movie,
    modifier: Modifier = Modifier
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val backgroundColor = AppColors.Background

    val isLightTheme = backgroundColor.luminance() > 0.5f

    val bannerSecondaryTextColor =
        if (isLightTheme) {
            Color.White
        } else {
            AppColors.TextSecondary
        }

    val bannerPrimaryTextColor =
        if (isLightTheme) {
            Color.White
        } else {
            AppColors.TextPrimary
        }

    Column(
        modifier = modifier
            .widthIn(
                max = BannerDefaults.detailsContentWidth(
                    windowType
                )
            )
            .padding(dimens.screenPadding)
    ) {

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
                        RoundedCornerShape(
                            dimens.cornerSmall
                        )
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
                    color = bannerSecondaryTextColor
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
                    color = bannerSecondaryTextColor
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
                color = bannerPrimaryTextColor
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
                color = if (isLightTheme) {
                    Color.White.copy(alpha = 0.85f)
                } else {
                    AppColors.TextSecondary
                }
            ),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )

        if (movie.languages.isNotEmpty()) {

            SpaceVertical(dimens.itemSpacing)

            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    dimens.itemSpacing
                )
            ) {

                item {

                    Text(
                        text = "Watch In",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontFamily = MontserratFontFamily(),
                            fontSize = dimens.bodyFont,
                            fontWeight = FontWeight.SemiBold,
                            color = bannerPrimaryTextColor
                        )
                    )
                }

                items(movie.languages) { language ->

                    Text(
                        text = language,
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontFamily = MontserratFontFamily(),
                            fontSize = dimens.captionFont,
                            fontWeight = FontWeight.Medium,
                            color = bannerSecondaryTextColor
                        )
                    )
                }
            }
        }

        SpaceVertical(dimens.sectionSpacing / 2)

        BannerActions()
    }
}