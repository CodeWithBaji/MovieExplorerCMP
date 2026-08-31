package com.moviewexplorer.app.features.home.defaults.components.topbar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType

@Composable
fun SearchBar(
    onClick: () -> Unit = {}
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val interactionSource = remember {
        MutableInteractionSource()
    }

    val hovered by interactionSource.collectIsHoveredAsState()

    val borderColor by animateColorAsState(
        targetValue = if (hovered) {
            AppColors.TextSecondary.copy(alpha = 0.35f)
        } else {
            Color.White.copy(alpha = 0.08f)
        },
        animationSpec = tween(150),
        label = "SearchBorder"
    )

    Surface(
        modifier = Modifier
            .width(
                when (windowType) {
                    WindowType.Compact -> dimens.searchBarWidth
                    WindowType.Medium -> 220.dp
                    WindowType.Expanded -> dimens.searchBarWidth
                }
            )
            .height(dimens.searchBarHeight)
            .hoverable(interactionSource)
            .clickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = onClick
            ),
        shape = RoundedCornerShape(50),
        color = AppColors.Surface.copy(alpha = 0.75f),
        border = BorderStroke(
            width = 1.dp,
            color = borderColor
        ),
        tonalElevation = 0.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = dimens.itemSpacing
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = AppColors.TextSecondary,
                modifier = Modifier.size(20.dp)
            )

            SpacerHorizontal(dimens.itemSpacing)

            Text(
                text = "Search movies & TV shows...",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = MontserratFontFamily(),
                    fontSize = dimens.bodyFont,
                    fontWeight = FontWeight.Medium,
                    color = AppColors.TextSecondary
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}