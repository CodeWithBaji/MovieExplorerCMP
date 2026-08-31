package com.moviewexplorer.app.features.listingScreen.tv.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens

@Composable
fun TvListingPaginationLoader(
    modifier: Modifier = Modifier
) {

    val dimens = LocalTvDimens.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = dimens.sectionSpacing
            ),
        contentAlignment = Alignment.Center
    ) {

        CircularProgressIndicator(
            modifier = Modifier.size(
                40.dp
            ),
            color = AppColors.Primary,
            strokeWidth = 3.dp
        )
    }
}