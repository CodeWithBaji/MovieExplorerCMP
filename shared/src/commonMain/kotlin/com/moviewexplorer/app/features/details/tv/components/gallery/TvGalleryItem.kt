package com.moviewexplorer.app.features.details.tv.components.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.domain.model.Banner

@Composable
fun TvGalleryItem(
    banner: Banner,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .width(360.dp)
            .height(200.dp)
            .focusable()
            .clip(
                RoundedCornerShape(5.dp)
            )
            .background(
                AppColors.Surface
            )
    ) {

        SubcomposeAsyncImage(
            model = ImageRequest.Builder(
                LocalPlatformContext.current
            )
                .data(banner.filePath)
                .crossfade(true)
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
    }
}