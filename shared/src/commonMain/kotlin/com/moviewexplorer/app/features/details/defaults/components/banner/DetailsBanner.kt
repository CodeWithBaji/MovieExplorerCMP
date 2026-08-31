package com.moviewexplorer.app.features.details.defaults.components.banner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.defaults.BannerDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType
import com.moviewexplorer.app.domain.model.Banner
import com.moviewexplorer.app.domain.model.Movie

@Composable
fun DetailsBanner(
    banner: Banner,
    movie: Movie
) {

    val windowType = LocalWindowType.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(
                BannerDefaults.detailsBannerHeight(windowType)
            )
            .background(AppColors.Background)
            .clipToBounds()
    ) {

        BannerBackground(
            banner = banner,
            isCompact = windowType == WindowType.Compact
        )

        BannerContent(
            movie = movie,
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}

