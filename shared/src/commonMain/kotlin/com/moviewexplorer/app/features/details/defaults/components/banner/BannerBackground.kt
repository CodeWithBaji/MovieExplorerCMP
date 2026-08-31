package com.moviewexplorer.app.features.details.defaults.components.banner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.SubcomposeAsyncImage
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.domain.model.Banner

@Composable
fun BannerBackground(
    banner: Banner,
    isCompact: Boolean
) {

    val backgroundColor = AppColors.Background


    val isLightTheme = backgroundColor.luminance() > 0.5f

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        if (isCompact) {

            AsyncImage(
                model = banner.filePath,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )

        } else {

            AsyncImage(
                model = banner.filePath,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = if (isLightTheme) {
                                listOf(
                                    Color.Black.copy(alpha = 0.75f),
                                    Color.Black.copy(alpha = 0.50f),
                                    Color.Black.copy(alpha = 0.15f),
                                    Color.Transparent
                                )
                            } else {
                                // EXACTLY your existing dark theme
                                listOf(
                                    AppColors.Background.copy(alpha = 0.85f),
                                    AppColors.Background.copy(alpha = 0.55f),
                                    AppColors.Background.copy(alpha = 0.20f),
                                    Color.Transparent
                                )
                            }
                        )
                    )
            )

            AsyncImage(
                model = banner.filePath,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.80f)
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
                            // EXACTLY your existing dark theme
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
    }
}