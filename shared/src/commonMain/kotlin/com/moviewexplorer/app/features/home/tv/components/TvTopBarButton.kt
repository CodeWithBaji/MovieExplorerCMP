package com.moviewexplorer.app.features.home.tv.components


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily


import com.moviewexplorer.app.core.designsystem.theme.AppColors

@Composable
fun TvTopBarButton(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    var focused by remember {
        mutableStateOf(false)
    }

    val scale by animateFloatAsState(
        targetValue = if (focused) {
            1.02f
        } else {
            1f
        },
        label = "TopBarButtonScale"
    )

    val tint by animateColorAsState(
        targetValue = if (focused) {
            AppColors.Primary
        } else {
            AppColors.TextSecondary
        },
        label = "TopBarButtonTint"
    )

    Row(
        modifier = modifier
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .onFocusChanged {
                focused = it.isFocused
            }
            .onPreviewKeyEvent { event ->

                if (event.type != KeyEventType.KeyDown) {
                    return@onPreviewKeyEvent false
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
                horizontal = 12.dp,
                vertical = 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = tint
        )

        SpacerHorizontal(10.dp)

        Text(
            text = text,
            color = tint,
            fontFamily = MontserratFontFamily(),
            fontWeight = if (focused) {
                FontWeight.SemiBold
            } else {
                FontWeight.Medium
            },
            maxLines = 1,
            softWrap = false
        )
    }
}
