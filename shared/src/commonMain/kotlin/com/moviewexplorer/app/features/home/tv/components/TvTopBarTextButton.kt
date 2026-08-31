package com.moviewexplorer.app.features.home.tv.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily

@Composable
fun TvTopBarTextButton(
    text: String,
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
        label = "TopBarTextButtonScale"
    )

    val color by animateColorAsState(
        targetValue = if (focused) {
            AppColors.Primary
        } else {
            AppColors.TextSecondary
        },
        label = "TopBarTextButtonColor"
    )

    Text(
        text = text,
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
            .padding(
                horizontal = 12.dp,
                vertical = 8.dp
            ),
        color = color,
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