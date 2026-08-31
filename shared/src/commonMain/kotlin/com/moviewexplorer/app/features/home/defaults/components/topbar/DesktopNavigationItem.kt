package com.moviewexplorer.app.features.home.defaults.components.topbar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
 fun DesktopNavigationItem(
    title: String,
    onClick: () -> Unit
) {

    val dimens = LocalAppDimens.current

    val interactionSource = remember {
        MutableInteractionSource()
    }

    val hovered by interactionSource.collectIsHoveredAsState()

    val textColor by animateColorAsState(
        targetValue = if (hovered) {
            AppColors.TextPrimary
        } else {
            AppColors.TextSecondary
        },
        animationSpec = tween(150),
        label = "NavigationTextColor"
    )

    Box(
        modifier = Modifier
            .padding(horizontal = dimens.itemSpacing / 2)
            .clip(
                RoundedCornerShape(dimens.cornerSmall)
            )
            .hoverable(interactionSource)
            .clickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = onClick
            )
            .padding(
                horizontal = dimens.itemSpacing,
                vertical = dimens.itemSpacing
            ),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge.copy(
                fontFamily = MontserratFontFamily(),
                fontSize = dimens.bodyFont,
                fontWeight = FontWeight.SemiBold,
                color = textColor
            ),
            maxLines = 1
        )
    }
}