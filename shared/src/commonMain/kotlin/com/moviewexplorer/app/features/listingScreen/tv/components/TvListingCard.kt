package com.moviewexplorer.app.features.listingScreen.tv.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.components.shimmers.tv.TvMovieImageShimmer
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.domain.model.Movie

@Composable
fun TvListingCard(
    movie: Movie,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    val dimens = LocalTvDimens.current

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                onClick = onClick
            ),
        shape = RoundedCornerShape(
            dimens.cornerMedium
        ),
        colors = CardDefaults.elevatedCardColors(
            containerColor = AppColors.Surface
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column {

            SubcomposeAsyncImage(
                model = movie.posterPath,
                contentDescription = movie.originalTitle,

                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f / 3f)
                    .clip(
                        RoundedCornerShape(
                            topStart = dimens.cornerMedium,
                            topEnd = dimens.cornerMedium
                        )
                    ),

                contentScale = ContentScale.Crop,

                loading = {

                    TvMovieImageShimmer()
                }
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        dimens.itemSpacing
                    )
            ) {

                Text(
                    text = movie.originalTitle.toString(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = MontserratFontFamily(),
                    fontSize = dimens.bodyFont,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.TextPrimary
                )

                SpaceVertical(
                    dimens.itemSpacing / 2
                )

                Text(
                    text = movie.releaseDate
                        ?.take(4)
                        ?: "N/A",
                    maxLines = 1,
                    fontFamily = MontserratFontFamily(),
                    fontSize = dimens.captionFont,
                    color = AppColors.TextSecondary
                )
            }
        }
    }
}