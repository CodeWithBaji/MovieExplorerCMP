package com.moviewexplorer.app.features.details.tv.components.creditsSection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
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
import com.moviewexplorer.app.domain.model.CastAndCrew
import com.moviewexplorer.app.features.details.tv.components.TvDetailTitles

@Composable
fun TvCreditsSection(
    title: String,
    credits: List<CastAndCrew>,
    firstItemRequester: FocusRequester,
    onUp: (() -> Unit)? = null,
    onDown: (() -> Unit)? = null
) {

    if (credits.isEmpty()) return

    val dimens = LocalTvDimens.current

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        TvDetailTitles(
            title = title
        )

        SpaceVertical(
            dimens.itemSpacing
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
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
                },

            contentPadding = PaddingValues(
                horizontal = dimens.screenPadding
            ),

            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {

            items(
                count = credits.size,
                key = { index ->
                    index
                }
            ) { index ->

                TvCreditItem(
                    castAndCrew = credits[index],

                    modifier = if (index == 0) {

                        Modifier.focusRequester(
                            firstItemRequester
                        )

                    } else {

                        Modifier
                    }
                )
            }
        }
    }
}