package com.moviewexplorer.app.features.details.defaults.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.domain.model.CastAndCrew

@Composable
fun CreditsSection(
    title: String,
    credits: List<CastAndCrew>
) {

    if (credits.isEmpty()) return

    val dimens = LocalAppDimens.current

    val roleTextColor =
        if (AppColors.Background.luminance() > 0.5f) {
            Color(0xFF62656C)
        } else {
            AppColors.TextSecondary
        }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        DetailTitles(title)

        SpaceVertical(dimens.itemSpacing)

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                horizontal = dimens.screenPadding
            ),
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {

            items(
                items = credits
            ) { credit ->

                CreditItem(
                    castAndCrew = credit
                )
            }
        }
    }
}