package com.moviewexplorer.app.features.details.defaults.components.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Collections
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
fun ViewAllGalleryItem(
    width: Dp,
    height: Dp,
    remainingCount: Int,
    onClick: () -> Unit
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
            .border(
                width = 0.5.dp,
                color = Color.White.copy(alpha = 0.08f),
                shape = RoundedCornerShape(dimens.cornerMedium)
            )
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            AppColors.Surface,
                            AppColors.Primary.copy(alpha = 0.10f)
                        )
                    )
                )
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(
                        AppColors.Primary.copy(alpha = 0.12f)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Outlined.Collections,
                    contentDescription = null,
                    tint = AppColors.Primary,
                    modifier = Modifier.size(20.dp)
                )
            }

            SpaceVertical(dimens.itemSpacing)

            Text(
                text = "+$remainingCount",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = MontserratFontFamily(),
                    fontSize = dimens.bodyFont,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.TextPrimary
                )
            )

            SpaceVertical(dimens.itemSpacing / 3)

            Text(
                text = "View All",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontFamily = MontserratFontFamily(),
                    fontSize = dimens.captionFont,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.PrimaryLight
                )
            )
        }
    }
}