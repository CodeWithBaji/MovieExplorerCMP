package com.moviewexplorer.app.core.components.shimmers.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens

@Composable
fun TvListingShimmer(
    columns: Int = 7,
    modifier: Modifier = Modifier
) {

    val dimens = LocalTvDimens.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(
                AppColors.Background
            ),
        contentPadding = PaddingValues(
            horizontal = dimens.screenPadding,
            vertical = dimens.sectionSpacing
        ),
        verticalArrangement = Arrangement.spacedBy(
            dimens.sectionSpacing
        )
    ) {

        items(4) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    dimens.cardSpacing
                )
            ) {

                repeat(columns) {

                    TvMovieCardShimmer(
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}