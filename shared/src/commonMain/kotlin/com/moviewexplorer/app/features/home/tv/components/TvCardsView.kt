package com.moviewexplorer.app.features.home.tv.components


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.components.shimmers.tv.TvMovieImageShimmer
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.defaults.tv.TvMovieCardDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvWindowType
import com.moviewexplorer.app.core.utils.toYear
import com.moviewexplorer.app.domain.model.Movie
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun TvCardsView(
    movie: Movie,
    modifier: Modifier = Modifier,
    onDetailsScreen: (id: Int) -> Unit,
    onFocused: () -> Unit = {}
) {

    val dimens = LocalTvDimens.current
    val windowType = LocalTvWindowType.current

    var focused by remember {
        mutableStateOf(false)
    }


    val scale by animateFloatAsState(
        targetValue = if (focused) {
            1.02f
        } else {
            1f
        },
        animationSpec = tween(150),
        label = "CardScale"
    )


    val borderColor by animateColorAsState(
        targetValue = if (focused) {
            AppColors.FocusBorder
        } else {
            Color.Transparent
        },
        animationSpec = tween(150),
        label = "BorderColor"
    )


    val elevation by animateDpAsState(
        targetValue = if (focused) {
            10.dp
        } else {
            4.dp
        },
        animationSpec = tween(150),
        label = "CardElevation"
    )

    val cardShape = RoundedCornerShape(
        dimens.cornerSmall
    )

    Column(
        modifier = Modifier
            .width(
                TvMovieCardDefaults.width(
                    windowType
                )
            )
    ) {

        ElevatedCard(
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(2f / 3f)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
                .zIndex(
                    if (focused) {
                        1f
                    } else {
                        0f
                    }
                )
                .onFocusChanged {

                    focused = it.isFocused

                    if (it.isFocused) {
                        onFocused()
                    }
                }
                .clickable {
                    onDetailsScreen(movie.id)
                }
                .focusTarget()
                .border(
                    width = if (focused) {
                        1.5.dp
                    } else {
                        0.dp
                    },
                    color = borderColor,
                    shape = cardShape
                ),

            colors = CardDefaults.cardColors(
                containerColor = AppColors.Surface
            ),

            shape = cardShape,

            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = elevation
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

                contentScale = ContentScale.Crop,

                /*
                 * Loading state
                 */
                loading = {

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {


                        TvMovieImageShimmer()
                    }
                },


                error = {

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(
                            painter = painterResource(
                                Res.drawable.movie_explorer_logo
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth(0.45f),
                            alpha = 0.55f
                        )
                    }
                }
            )
        }

        SpaceVertical(
            dimens.itemSpacing
        )


        Text(
            text = movie.originalTitle,
            minLines = 2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,

            fontFamily = MontserratFontFamily(),
            fontWeight = FontWeight.SemiBold,
            fontSize = dimens.bodyFont,

            color = if (focused) {
                AppColors.TextPrimary
            } else {
                AppColors.TextSecondary
            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimens.itemSpacing
                )
        )

        SpaceVertical(
            dimens.itemSpacing / 2
        )


        Text(
            text = movie.releaseDate.toYear(),

            fontFamily = MontserratFontFamily(),
            fontWeight = FontWeight.Medium,
            fontSize = dimens.captionFont,

            color = if (focused) {
                AppColors.TextPrimary
            } else {
                AppColors.TextTertiary
            },

            modifier = Modifier.padding(
                start = dimens.itemSpacing
            )
        )
    }
}