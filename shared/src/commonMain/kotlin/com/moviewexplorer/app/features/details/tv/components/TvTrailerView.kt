package com.moviewexplorer.app.features.details.tv.components



import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
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
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType
import com.moviewexplorer.app.core.utils.safeRequestFocus
import com.moviewexplorer.app.domain.model.Video


@Composable
fun TvTrailerView(
    video: Video,
    openYoutube: (videoId: String) -> Unit,
    focusRequester: FocusRequester,
    upRequester: FocusRequester? = null,
    downRequester: FocusRequester? = null
) {

    val dimens = LocalTvDimens.current
    val windowType = LocalTvWindowType.current

    val trailerMaxWidth = when (windowType) {
        TvWindowType.Compact -> 850.dp
        TvWindowType.Medium -> 1050.dp
        TvWindowType.Expanded -> 1200.dp
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        TvDetailTitles(
            title = "TRAILER"
        )

        SpaceVertical(dimens.itemSpacing)

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(
                        max = trailerMaxWidth
                    )
                    .padding(
                        horizontal = dimens.screenPadding
                    )
                    .height(
                        when (windowType) {
                            TvWindowType.Compact -> 360.dp
                            TvWindowType.Medium -> 420.dp
                            TvWindowType.Expanded -> 480.dp
                        }
                    )
                    .clip(
                        RoundedCornerShape(dimens.cornerLarge)
                    )
                    .background(AppColors.Surface)
                    .focusRequester(focusRequester)
                    .focusProperties {

                    upRequester?.let {
                        up = it
                    }
                }
                    .onPreviewKeyEvent { event ->

                        if (event.type == KeyEventType.KeyDown &&
                            event.key == Key.DirectionDown
                        ) {
                            downRequester?.safeRequestFocus() == true
                        } else {
                            false
                        }
                    }
                    .focusable()
                    .clickable {
                        openYoutube(video.key)
                    }
            ) {

                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(
                        LocalPlatformContext.current
                    )
                        .data(
                            "https://img.youtube.com/vi/${video.key}/maxresdefault.jpg"
                        )
                        .crossfade(true)
                        .crossfade(300)
                        .build(),
                    contentDescription = video.name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,

                    loading = {

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(AppColors.Surface),
                            contentAlignment = Alignment.Center
                        ) {

                            CircularProgressIndicator(
                                modifier = Modifier.size(40.dp),
                                strokeWidth = 3.dp,
                                color = AppColors.Primary
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

                            Icon(
                                imageVector = Icons.Outlined.Movie,
                                contentDescription = null,
                                tint = AppColors.TextSecondary,
                                modifier = Modifier.size(56.dp)
                            )
                        }
                    }
                )

                // Gradient
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0.10f),
                                    Color.Transparent,
                                    Color.Black.copy(alpha = 0.20f),
                                    Color.Black.copy(alpha = 0.80f)
                                )
                            )
                        )
                )

                // Play button
                Surface(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(90.dp),
                    shape = CircleShape,
                    color = AppColors.Primary,
                    shadowElevation = 8.dp
                ) {

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Play trailer",
                            tint = Color.White,
                            modifier = Modifier.fillMaxSize(0.55f)
                        )
                    }
                }

                // Bottom information
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .padding(dimens.itemSpacing)
                ) {

                    Text(
                        text = "OFFICIAL TRAILER",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontFamily = MontserratFontFamily(),
                            fontSize = dimens.captionFont,
                            fontWeight = FontWeight.SemiBold,
                            color = AppColors.Primary
                        )
                    )

                    if (video.name.isNotBlank()) {

                        SpaceVertical(
                            dimens.itemSpacing / 3
                        )

                        Text(
                            text = video.name,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontFamily = MontserratFontFamily(),
                                fontSize = dimens.bodyFont,
                                fontWeight = FontWeight.SemiBold,
                                color = AppColors.TextPrimary
                            )
                        )
                    }
                }
            }
        }
    }
}