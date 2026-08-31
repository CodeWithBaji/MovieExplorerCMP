package com.moviewexplorer.app.features.details.tv.components.tvBanner

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.defaults.tv.TvBannerDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvWindowType
import com.moviewexplorer.app.core.utils.toYear
import com.moviewexplorer.app.domain.model.Movie
import com.moviewexplorer.app.features.home.tv.components.TvGenreItem

@Composable
fun TvBannerContent(
    movie: Movie,
    modifier: Modifier = Modifier,
    watchRequester: FocusRequester,
    watchListRequester: FocusRequester,
    castRequester: FocusRequester,
    upRequester: FocusRequester,
    downRequester: FocusRequester,
    onButtonFocusChanged: (Boolean) -> Unit = {}
) {

    val dimens = LocalTvDimens.current
    val windowType = LocalTvWindowType.current

    Column(
        modifier = modifier
            .widthIn(
                max = TvBannerDefaults.detailsContentWidth(windowType)
            )
            .padding(dimens.screenPadding)
    ) {


        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "FEATURED",
                fontFamily = MontserratFontFamily(),
                fontSize = dimens.captionFont,
                fontWeight = FontWeight.Bold,
                color = AppColors.TextPrimary,
                modifier = Modifier
                    .background(
                        color = AppColors.Primary,
                        shape = RoundedCornerShape(
                            dimens.cornerSmall
                        )
                    )
                    .padding(
                        horizontal = dimens.itemSpacing / 2,
                        vertical = dimens.itemSpacing / 4
                    )
            )

            SpacerHorizontal(
                dimens.itemSpacing
            )

            Text(
                text = movie.releaseDate.toYear(),
                fontFamily = MontserratFontFamily(),
                fontSize = dimens.captionFont,
                fontWeight = FontWeight.Medium,
                color = AppColors.TextSecondary
            )

            SpacerHorizontal(
                dimens.itemSpacing
            )

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = AppColors.Rating,
                modifier = Modifier.size(16.dp)
            )

        }

        SpaceVertical(
            dimens.itemSpacing
        )


        Text(
            text = movie.originalTitle,
            fontFamily = MontserratFontFamily(),
            fontSize = dimens.titleFont,
            fontWeight = FontWeight.Bold,
            color = AppColors.TextPrimary,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        SpaceVertical(
            dimens.itemSpacing
        )


        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing / 2
            ),
            userScrollEnabled = false
        ) {

            items(
                items = movie.genres
            ) {

                TvGenreItem(it)
            }
        }

        SpaceVertical(
            dimens.itemSpacing
        )


        Text(
            text = movie.overview,
            modifier = Modifier
                .height(
                    TvBannerDefaults.detailsOverviewHeight(windowType)
                )
                .clipToBounds(),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = dimens.bodyFont,
                color = Color(0xFFF6C7C7)
            ),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )

        SpaceVertical(
            dimens.itemSpacing
        )


        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                dimens.itemSpacing
            ),
            userScrollEnabled = false
        ) {

            item {

                Text(
                    text = "Watch In",
                    fontFamily = MontserratFontFamily(),
                    fontSize = dimens.bodyFont,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.TextPrimary
                )
            }

            items(
                items = movie.languages
            ) { language ->

                Surface(
                    shape = RoundedCornerShape(
                        dimens.cornerSmall
                    ),
                    color = AppColors.Surface,
                    border = BorderStroke(
                        width = 1.dp,
                        color = AppColors.Border
                    )
                ) {

                    Text(
                        text = language,
                        modifier = Modifier.padding(
                            horizontal = dimens.itemSpacing,
                            vertical = dimens.itemSpacing / 2
                        ),
                        fontFamily = MontserratFontFamily(),
                        fontSize = dimens.captionFont,
                        fontWeight = FontWeight.Medium,
                        color = AppColors.TextSecondary
                    )
                }
            }
        }

        SpaceVertical(
            dimens.sectionSpacing / 3
        )


        TvBannerActions(
            watchRequester = watchRequester,
            watchListRequester = watchListRequester,
            upRequester = upRequester,
            downRequester = downRequester,
            castRequester = castRequester,
            onFocusChanged = onButtonFocusChanged
        )
    }
}