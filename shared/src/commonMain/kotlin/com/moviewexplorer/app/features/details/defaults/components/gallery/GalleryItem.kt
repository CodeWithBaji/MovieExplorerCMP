package com.moviewexplorer.app.features.details.defaults.components.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BrokenImage
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.domain.model.Banner


@Composable
fun GalleryItem(
    banner: Banner,
    width: Dp,
    height: Dp
) {

    val dimens = LocalAppDimens.current

    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .clip(
                RoundedCornerShape(dimens.cornerMedium)
            )
            .background(AppColors.Surface)
    ) {

        SubcomposeAsyncImage(
            model = ImageRequest.Builder(
                LocalPlatformContext.current
            )
                .data(banner.filePath)
                .crossfade(true)
                .crossfade(300)
                .build(),
            contentDescription = null,
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
                        modifier = Modifier.size(28.dp),
                        strokeWidth = 2.dp,
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
                        imageVector = Icons.Outlined.BrokenImage,
                        contentDescription = null,
                        tint = AppColors.TextSecondary,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.05f),
                            Color.Black.copy(alpha = 0.18f)
                        )
                    )
                )
        )
    }
}

