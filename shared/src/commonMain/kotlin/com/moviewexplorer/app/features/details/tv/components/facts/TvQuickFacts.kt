package com.moviewexplorer.app.features.details.tv.components.facts

import androidx.compose.foundation.focusable
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.domain.model.Movie

@Composable
fun TvQuickFacts(
    movie: Movie,
    modifier: Modifier = Modifier,
    focusRequester: FocusRequester,
    onUp: (() -> Unit)? = null,
    onDown: (() -> Unit)? = null
) {

    val dimens = LocalTvDimens.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimens.screenPadding)
            .focusRequester(focusRequester)
            .onPreviewKeyEvent { event ->

                if (event.type != KeyEventType.KeyDown) {
                    return@onPreviewKeyEvent false
                }

                when (event.key) {

                    Key.DirectionUp -> {
                        onUp?.invoke()
                        true
                    }

                    Key.DirectionDown -> {
                        onDown?.invoke()
                        true
                    }

                    else -> false
                }
            }
            .focusable()
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {

            TvFactCard(
                modifier = Modifier.weight(1f),
                title = "BUDGET",
                value = movie.budget.toString(),
                icon = Icons.Outlined.Payments
            )

            TvFactCard(
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

            TvFactCard(
                modifier = Modifier.weight(1f),
                title = "LOCATIONS",
                value = movie.productionCountries
                    ?.takeIf { it.isNotEmpty() }
                    ?.joinToString { it.name }
                    ?: "N/A",
                icon = Icons.Outlined.LocationOn
            )

            TvFactCard(
                modifier = Modifier.weight(1f),
                title = "PRODUCTION",
                value = movie.productionCompanies
                    ?.takeIf { it.isNotEmpty() }
                    ?.joinToString { it.name }
                    ?: "N/A",
                icon = Icons.Outlined.Business
            )
        }
    }
}