package com.moviewexplorer.app.core.components.shimmers.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens

@Composable
fun TvDetailsShimmer() {

    val dimens = LocalTvDimens.current

    Column(
        modifier = Modifier.fillMaxWidth()
            .background(AppColors.Background)
    ) {

        // DETAILS TOP BANNER / HERO
        TvShimmerBox(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
        )

        SpaceVertical(dimens.sectionSpacing)

        TvShimmerSection()

        SpaceVertical(dimens.sectionSpacing)

        TvShimmerSection()

        SpaceVertical(dimens.sectionSpacing)

        TvShimmerSection()
    }
}