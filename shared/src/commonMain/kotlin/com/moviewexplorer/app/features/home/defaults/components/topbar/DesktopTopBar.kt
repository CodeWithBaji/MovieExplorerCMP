package com.moviewexplorer.app.features.home.defaults.components.topbar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType
import com.moviewexplorer.app.core.utils.ListingType

@Composable
fun DesktopTopBar(
    elevated: Boolean,
    onListingScreen: (ListingType) -> Unit,
    onSettingsClick: () -> Unit
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val backgroundColor by animateColorAsState(
        targetValue = if (elevated) {
            AppColors.Background.copy(alpha = 0.98f)
        } else {
            AppColors.Background.copy(alpha = 0.88f)
        },
        animationSpec = tween(300),
        label = "TopBarBackground"
    )

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = backgroundColor,
        tonalElevation = 0.dp,
        shadowElevation = if (elevated) 4.dp else 0.dp,
        border = if (elevated) {
            BorderStroke(
                width = 0.5.dp,
                color = Color.White.copy(alpha = 0.06f)
            )
        } else {
            null
        }
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.toolbarHeight)
                .padding(horizontal = dimens.screenPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TopBarBrand()

            Spacer(
                modifier = Modifier.width(
                    if (windowType == WindowType.Expanded) {
                        48.dp
                    } else {
                        28.dp
                    }
                )
            )

            DesktopNavigationItem(
                title = "Trending",
                onClick = {
                    onListingScreen(ListingType.TRENDING)
                }
            )

            DesktopNavigationItem(
                title = "Popular",
                onClick = {
                    onListingScreen(ListingType.POPULAR)
                }
            )

            DesktopNavigationItem(
                title = "Top Rated",
                onClick = {
                    onListingScreen(ListingType.TOP_RATED)
                }
            )

            Spacer(
                modifier = Modifier.weight(1f)
            )

            SearchBar(
                onClick = {
                    onListingScreen(ListingType.SEARCH)
                }
            )

            SpacerHorizontal(dimens.itemSpacing)

            IconButton(
                onClick = onSettingsClick
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = AppColors.TextSecondary
                )
            }
        }
    }
}