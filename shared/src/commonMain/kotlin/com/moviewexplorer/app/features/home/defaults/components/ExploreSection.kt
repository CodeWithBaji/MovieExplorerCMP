package com.moviewexplorer.app.features.home.defaults.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.utils.ListingType

@Composable
fun ExploreSection(
    onListingScreen: (ListingType) -> Unit
) {

    val dimens = LocalAppDimens.current

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        HomeTitles(
            title = "Explore"
        )

        SpaceVertical(dimens.itemSpacing)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimens.screenPadding),
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {

            ExploreItem(
                modifier = Modifier.weight(1f),
                title = "Trending",
                icon = Icons.Default.LocalFireDepartment,
                onClick = {
                    onListingScreen(ListingType.TRENDING)
                }
            )

            ExploreItem(
                modifier = Modifier.weight(1f),
                title = "Popular",
                icon = Icons.Default.TrendingUp,
                onClick = {
                    onListingScreen(ListingType.POPULAR)
                }
            )

            ExploreItem(
                modifier = Modifier.weight(1f),
                title = "Top Rated",
                icon = Icons.Default.Star,
                onClick = {
                    onListingScreen(ListingType.TOP_RATED)
                }
            )
        }
    }
}