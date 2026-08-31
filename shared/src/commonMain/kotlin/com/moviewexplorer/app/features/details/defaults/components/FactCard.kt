package com.moviewexplorer.app.features.details.defaults.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens


@Composable
fun FactCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    icon: ImageVector
) {

    val dimens = LocalAppDimens.current

    ElevatedCard(
        modifier = modifier
            .heightIn(min = 160.dp),
        shape = RoundedCornerShape(dimens.cornerLarge),
        colors = CardDefaults.elevatedCardColors(
            containerColor = AppColors.Surface
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.screenPadding)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(
                            RoundedCornerShape(
                                dimens.cornerSmall
                            )
                        )
                        .background(
                            AppColors.Primary.copy(alpha = 0.12f)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = AppColors.Primary,
                        modifier = Modifier.size(18.dp)
                    )
                }

                SpacerHorizontal(dimens.itemSpacing)

                Text(
                    text = title,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontFamily = MontserratFontFamily(),
                        fontSize = dimens.captionFont,
                        fontWeight = FontWeight.SemiBold,
                        color = AppColors.TextSecondary
                    )
                )
            }

            SpaceVertical(dimens.itemSpacing)

            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = MontserratFontFamily(),
                    fontSize = dimens.bodyFont,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.TextPrimary,
                    lineHeight = dimens.bodyFont * 1.4f
                )
            )
        }
    }
}