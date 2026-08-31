package com.moviewexplorer.app.core.components.shimmers.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
fun ShimmerBox(
    brush: Brush,
    modifier: Modifier = Modifier
) {

    val dimens = LocalAppDimens.current

    Box(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    dimens.cornerMedium
                )
            )
            .background(brush)
    )
}