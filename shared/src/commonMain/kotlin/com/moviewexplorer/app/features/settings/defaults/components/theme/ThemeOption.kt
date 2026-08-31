package com.moviewexplorer.app.features.settings.defaults.components.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
fun ThemeOption(
    title: String,
    icon: ImageVector,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    val dimens = LocalAppDimens.current

    val containerColor by animateColorAsState(
        targetValue = if (selected) {
            AppColors.Primary.copy(alpha = 0.15f)
        } else {
            AppColors.Surface
        },
        label = "ThemeContainerColor"
    )

    val borderColor by animateColorAsState(
        targetValue = if (selected) {
            AppColors.Primary
        } else {
            AppColors.SurfaceVariant
        },
        label = "ThemeBorderColor"
    )

    Column(
        modifier = modifier
            .clip(
                RoundedCornerShape(dimens.cornerMedium)
            )
            .background(containerColor)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(dimens.cornerMedium)
            )
            .clickable {
                onClick()
            }
            .padding(
                vertical = dimens.itemSpacing * 1.5f,
                horizontal = dimens.itemSpacing
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = if (selected) {
                AppColors.Primary
            } else {
                AppColors.TextSecondary
            },
            modifier = Modifier.size(24.dp)
        )

        SpaceVertical(dimens.itemSpacing / 2)

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontFamily = MontserratFontFamily(),
                fontSize = dimens.captionFont,
                fontWeight = if (selected) {
                    FontWeight.SemiBold
                } else {
                    FontWeight.Medium
                },
                color = if (selected) {
                    AppColors.TextPrimary
                } else {
                    AppColors.TextSecondary
                }
            )
        )
    }
}