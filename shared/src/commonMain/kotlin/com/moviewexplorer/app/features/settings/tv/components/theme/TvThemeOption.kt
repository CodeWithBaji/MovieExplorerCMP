package com.moviewexplorer.app.features.settings.tv.components.theme



import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens

@Composable
fun TvThemeOption(
    title: String,
    icon: ImageVector,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    val dimens = LocalTvDimens.current

    var focused by remember {
        mutableStateOf(false)
    }

    val scale by animateFloatAsState(
        targetValue = if (focused) 1.02f else 1f,
        label = "ThemeOptionScale"
    )

    val containerColor by animateColorAsState(
        targetValue = if (selected) {
            AppColors.Primary.copy(alpha = 0.15f)
        } else {
            AppColors.Surface
        },
        label = "ThemeContainerColor"
    )

    val borderColor by animateColorAsState(
        targetValue = if (selected || focused) {
            AppColors.Primary
        } else {
            AppColors.SurfaceVariant
        },
        label = "ThemeBorderColor"
    )

    Column(
        modifier = modifier
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .onFocusChanged {
                focused = it.isFocused
            }
            .clip(
                RoundedCornerShape(
                    dimens.cornerMedium
                )
            )
            .background(containerColor)
            .border(
                width = if (selected || focused) 2.dp else 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(
                    dimens.cornerMedium
                )
            )
            .onKeyEvent { event ->

                if (event.type != KeyEventType.KeyDown) {
                    return@onKeyEvent false
                }

                when (event.key) {

                    Key.Enter,
                    Key.NumPadEnter,
                    Key.DirectionCenter -> {
                        onClick()
                        true
                    }

                    else -> false
                }
            }
            .focusable()
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
            contentDescription = title,
            tint = if (selected || focused) {
                AppColors.Primary
            } else {
                AppColors.TextSecondary
            },
            modifier = Modifier.size(32.dp)
        )

        SpaceVertical(
            dimens.itemSpacing
        )

        Text(
            text = title,
            fontFamily = MontserratFontFamily(),
            fontSize = dimens.bodyFont,
            fontWeight = if (selected || focused) {
                FontWeight.SemiBold
            } else {
                FontWeight.Medium
            },
            color = if (selected || focused) {
                AppColors.TextPrimary
            } else {
                AppColors.TextSecondary
            }
        )
    }
}