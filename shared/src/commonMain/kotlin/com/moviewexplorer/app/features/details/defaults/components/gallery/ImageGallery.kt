package com.moviewexplorer.app.features.details.defaults.components.gallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.designsystem.ui.defaults.GalleryDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType
import com.moviewexplorer.app.domain.model.Banner

@Composable
fun ImageGallery(
    banners: List<Banner>,
    onViewAll: () -> Unit
) {

    if (banners.isEmpty()) return

    val windowType = LocalWindowType.current
    val dimens = LocalAppDimens.current

    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth()
    ) {

        val columns = GalleryDefaults.columns(windowType)

        val maxItems = when (windowType) {
            WindowType.Compact -> 6
            WindowType.Medium -> 12
            WindowType.Expanded -> 12
        }

        val hasMore = banners.size > maxItems

        val visibleItems = if (hasMore) {
            banners.take(maxItems - 1)
        } else {
            banners.take(maxItems)
        }

        val itemWidth =
            (maxWidth - dimens.cardSpacing * (columns - 1)) / columns

        val itemHeight =
            GalleryDefaults.imageHeight(windowType)

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            maxItemsInEachRow = columns,
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            ),
            verticalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {

            visibleItems.forEach { banner ->

                GalleryItem(
                    banner = banner,
                    width = itemWidth,
                    height = itemHeight
                )
            }

            if (hasMore) {

                ViewAllGalleryItem(
                    width = itemWidth,
                    height = itemHeight,
                    remainingCount = banners.size - visibleItems.size,
                    onClick = onViewAll
                )
            }
        }
    }
}

