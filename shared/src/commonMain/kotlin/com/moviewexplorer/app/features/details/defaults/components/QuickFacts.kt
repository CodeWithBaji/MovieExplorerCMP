package com.moviewexplorer.app.features.details.defaults.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Business
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Payments
import androidx.compose.material.icons.outlined.TrendingUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.domain.model.Movie

@Composable
fun QuickFacts(
    movie: Movie
) {

    val dimens = LocalAppDimens.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimens.screenPadding)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {

            FactCard(
                modifier = Modifier.weight(1f),
                title = "BUDGET",
                value = movie.budget.toString(),
                icon = Icons.Outlined.Payments
            )

            FactCard(
                modifier = Modifier.weight(1f),
                title = "REVENUE",
                value = movie.revenue.toString(),
                icon = Icons.Outlined.TrendingUp
            )
        }

        SpaceVertical(dimens.cardSpacing)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {

            FactCard(
                modifier = Modifier.weight(1f),
                title = "LOCATIONS",
                value = if (movie.productionCountries.isNullOrEmpty()) {
                    "N/A"
                } else {
                    movie.productionCountries.joinToString {
                        it.name
                    }
                },
                icon = Icons.Outlined.LocationOn
            )

            FactCard(
                modifier = Modifier.weight(1f),
                title = "PRODUCTION",
                value = if (movie.productionCompanies.isNullOrEmpty()) {
                    "N/A"
                } else {
                    movie.productionCompanies.joinToString {
                        it.name
                    }
                },
                icon = Icons.Outlined.Business
            )
        }
    }
}