package com.moviewexplorer.app.features.home.defaults.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.defaults.MovieCardDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.utils.toYear
import com.moviewexplorer.app.domain.model.Movie
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun ContentCards(
    movies: List<Movie>,
    onDetailsScreen: (id: Int) -> Unit
) {

    val dimens = LocalAppDimens.current

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(
            horizontal = dimens.screenPadding
        ),
        horizontalArrangement = Arrangement.spacedBy(
            dimens.cardSpacing
        )
    ) {

        items(
            items = movies,
            key = { it.id }
        ) { movie ->

            CardsView(
                movie = movie,
                onDetailsScreen = onDetailsScreen
            )
        }
    }
}

@Composable
fun CardsView(
    movie: Movie,
    modifier: Modifier = Modifier,
    onDetailsScreen: (id: Int) -> Unit
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val montserrat = MontserratFontFamily()

    val interactionSource = remember {
        MutableInteractionSource()
    }

    val pressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = if (pressed) 0.97f else 1f,
        animationSpec = tween(120),
        label = "MovieCardScale"
    )

    Column(
        modifier = modifier.width(
            MovieCardDefaults.width(windowType)
        )
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f / 3f)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
                .clickable(
                    interactionSource = interactionSource,
                    indication = LocalIndication.current
                ) {
                    onDetailsScreen(movie.id)
                },
            shape = RoundedCornerShape(
                dimens.cornerSmall
            ),
            colors = CardDefaults.cardColors(
                containerColor = AppColors.Surface
            )
        ) {

            SubcomposeAsyncImage(
                model = ImageRequest.Builder(
                    LocalPlatformContext.current
                )
                    .data(movie.posterPath)
                    .crossfade(true)
                    .crossfade(300)
                    .build(),
                contentDescription = movie.originalTitle,
                modifier = Modifier.fillMaxSize(),

                // Important
                contentScale = ContentScale.Crop,

                loading = {


                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(AppColors.Background),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(36.dp),
                            color = AppColors.Primary,
                            strokeWidth = 2.5.dp,
                            trackColor = AppColors.TextSecondary.copy(alpha = 0.15f)
                        )
                    }
                },

                error = {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(AppColors.Surface),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(
                            painter = painterResource(
                                Res.drawable.movie_explorer_logo
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth(0.45f)
                        )
                    }
                }
            )
        }

        SpaceVertical(dimens.itemSpacing)

        Text(
            text = movie.originalTitle,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.titleSmall.copy(
                fontFamily = montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = dimens.bodyFont,
                color = AppColors.TextPrimary
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        SpaceVertical(dimens.itemSpacing / 3)

        Text(
            text = movie.releaseDate.toYear(),
            style = MaterialTheme.typography.bodySmall.copy(
                fontFamily = montserrat,
                fontWeight = FontWeight.Medium,
                fontSize = dimens.captionFont,
                color = AppColors.TextRed
            ),
            maxLines = 1
        )
    }
}