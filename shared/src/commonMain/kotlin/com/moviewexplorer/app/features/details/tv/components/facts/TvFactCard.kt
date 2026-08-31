package com.moviewexplorer.app.features.details.tv.components.facts

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens

@Composable
fun TvFactCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    icon: ImageVector
) {

    val dimens = LocalTvDimens.current

    var isFocused by remember {
        mutableStateOf(false)
    }

    val scale by animateFloatAsState(
        targetValue = if (isFocused) 1.05f else 1f,
        animationSpec = tween(150),
        label = "TvFactCardScale"
    )

    ElevatedCard(
        modifier = modifier
            .height(180.dp)
            .onFocusChanged {
                isFocused = it.isFocused
            }
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            },

        shape = RoundedCornerShape(
            dimens.cornerLarge
        ),

        colors = CardDefaults.elevatedCardColors(
            containerColor = AppColors.Surface
        ),

        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimens.screenPadding)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(
                            RoundedCornerShape(
                                dimens.cornerSmall
                            )
                        )
                        .background(
                            AppColors.Primary.copy(
                                alpha = 0.12f
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = AppColors.Primary,
                        modifier = Modifier.size(22.dp)
                    )
                }

                SpacerHorizontal(
                    dimens.itemSpacing
                )

                Text(
                    text = title,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontFamily = MontserratFontFamily(),
                        fontSize = dimens.captionFont,
                        fontWeight = FontWeight.SemiBold,
                        color = AppColors.TextSecondary
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            SpaceVertical(
                dimens.itemSpacing * 1.5f
            )

            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = MontserratFontFamily(),
                    fontSize = dimens.bodyFont,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.TextPrimary,
                    lineHeight = dimens.bodyFont * 1.4f
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}