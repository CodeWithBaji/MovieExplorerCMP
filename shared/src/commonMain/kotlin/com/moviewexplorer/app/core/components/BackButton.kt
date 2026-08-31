package com.moviewexplorer.app.core.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.theme.AppColors

@Composable
fun BackButton(
    circleSize: Dp,
    arrowSize: Dp,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var focused by remember { mutableStateOf(false) }

    // Resolve theme colors outside any non-composable scope
    val background by animateColorAsState(
        targetValue = if (focused) {
            AppColors.Primary
        } else {
            AppColors.SurfaceElevated
        },
        label = "BackButtonBackground"
    )

    val border by animateColorAsState(
        targetValue = if (focused) {
            AppColors.FocusBorder
        } else {
            AppColors.BorderStrong
        },
        label = "BackButtonBorder"
    )

    val iconColor = if (focused) {
        Color.White
    } else {
        AppColors.TextPrimary
    }

    val scale by animateFloatAsState(
        targetValue = if (focused) 1.08f else 1f,
        label = "BackButtonScale"
    )

    Box(
        modifier = modifier
            .size(circleSize)
            .onFocusChanged {
                focused = it.isFocused
            }
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .clip(CircleShape)
            .background(background)
            .border(
                width = 2.dp,
                color = border,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = iconColor,
            modifier = Modifier.size(arrowSize)
        )
    }
}