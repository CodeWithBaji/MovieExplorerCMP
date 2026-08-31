package com.moviewexplorer.app.features.details.tv.components.tvBanner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.focus.FocusRequester
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.defaults.tv.TvBannerDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType
import com.moviewexplorer.app.domain.model.Banner
import com.moviewexplorer.app.domain.model.Movie

@Composable
fun TvDetailsBanner(
    banner: Banner,
    movie: Movie,
    watchRequester: FocusRequester,
    watchListRequester: FocusRequester,
    castRequester: FocusRequester,
    upRequester: FocusRequester,
    downRequester: FocusRequester,
    onButtonFocusChanged: (Boolean) -> Unit = {}
) {

    val windowType = LocalTvWindowType.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(
                TvBannerDefaults.detailsBannerHeight(windowType)
            )
            .clipToBounds()
            .background(
                AppColors.Background
            )
    ) {

        TvBannerBackground(
            banner = banner,
            isCompact = windowType == TvWindowType.Compact
        )

        TvBannerContent(
            movie = movie,
            modifier = Modifier.align(Alignment.BottomStart),
            watchRequester = watchRequester,
            watchListRequester = watchListRequester,
            castRequester = castRequester,
            upRequester = upRequester,
            downRequester = downRequester,
            onButtonFocusChanged = onButtonFocusChanged
        )
    }
}