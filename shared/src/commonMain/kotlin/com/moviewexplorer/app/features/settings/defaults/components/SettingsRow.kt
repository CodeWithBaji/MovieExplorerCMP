package com.moviewexplorer.app.features.settings.defaults.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
fun SettingsRow(
    title: String,
    value: String? = null,
    showArrow: Boolean = false,
    onClick: () -> Unit = {}
) {

    val dimens = LocalAppDimens.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(dimens.cornerMedium)
            )
            .clickable {
                onClick()
            }
            .padding(
                vertical = dimens.itemSpacing * 1.5f,
                horizontal = dimens.itemSpacing
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = MontserratFontFamily(),
                fontSize = dimens.bodyFont,
                fontWeight = FontWeight.Medium,
                color = AppColors.TextPrimary
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        if (value != null) {

            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = MontserratFontFamily(),
                    fontSize = dimens.bodyFont,
                    color = AppColors.TextSecondary
                )
            )
        }

        if (showArrow) {

            SpacerHorizontal(dimens.itemSpacing / 2)

            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                contentDescription = null,
                tint = AppColors.TextSecondary
            )
        }
    }
}