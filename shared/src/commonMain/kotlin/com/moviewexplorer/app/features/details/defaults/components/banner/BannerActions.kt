package com.moviewexplorer.app.features.details.defaults.components.banner

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.defaults.BannerDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType

@Composable
fun BannerActions() {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    BannerDefaults.detailsButtonHeight(windowType)
                )
                .background(
                    AppColors.Primary,
                    RoundedCornerShape(dimens.cornerMedium)
                ),
            contentAlignment = Alignment.Center
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = Color.White
                )

                SpacerHorizontal(dimens.itemSpacing)

                Text(
                    text = "Watch Now",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = dimens.bodyFont,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                )
            }
        }

        SpaceVertical(dimens.itemSpacing)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    BannerDefaults.detailsButtonHeight(windowType)
                )
                .background(
                    AppColors.Surface.copy(alpha = 0.85f),
                    RoundedCornerShape(dimens.cornerMedium)
                )
                .border(
                    BorderStroke(
                        width = 0.5.dp,
                        color = AppColors.Border
                    ),
                    RoundedCornerShape(dimens.cornerMedium)
                ),
            contentAlignment = Alignment.Center
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Outlined.Bookmark,
                    contentDescription = null,
                    tint = AppColors.TextPrimary
                )

                SpacerHorizontal(dimens.itemSpacing)

                Text(
                    text = "Add To Watchlist",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = dimens.bodyFont,
                        fontWeight = FontWeight.SemiBold,
                        color = AppColors.TextPrimary
                    )
                )
            }
        }
    }
}