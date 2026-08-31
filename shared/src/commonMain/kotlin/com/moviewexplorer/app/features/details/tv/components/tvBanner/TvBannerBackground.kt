package com.moviewexplorer.app.features.details.tv.components.tvBanner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.domain.model.Banner

@Composable
fun TvBannerBackground(
    banner: Banner,
    isCompact: Boolean
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        AsyncImage(
            model = banner.filePath,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )

        // Strong left-to-right blend
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        colorStops = arrayOf(
                            0.00f to AppColors.Background.copy(alpha = 1f),
                            0.18f to AppColors.Background.copy(alpha = 0.98f),
                            0.32f to AppColors.Background.copy(alpha = 0.90f),
                            0.46f to AppColors.Background.copy(alpha = 0.72f),
                            0.60f to AppColors.Background.copy(alpha = 0.48f),
                            0.74f to AppColors.Background.copy(alpha = 0.22f),
                            0.88f to Color.Transparent,
                            1.00f to Color.Transparent
                        )
                    )
                )
        )

        // Bottom fade
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.00f to Color.Transparent,
                            0.55f to Color.Transparent,
                            0.72f to Color.Black.copy(alpha = 0.12f),
                            0.86f to Color.Black.copy(alpha = 0.45f),
                            1.00f to Color.Black.copy(alpha = 0.90f)
                        )
                    )
                )
        )
    }
}