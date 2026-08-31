package com.moviewexplorer.app.features.details.tv.components.creditsSection

import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusRequester
import com.moviewexplorer.app.domain.model.CastAndCrew

@Composable
fun TvCastView(
    casts: List<CastAndCrew>,
    firstItemRequester: FocusRequester,
    onUp: (() -> Unit)? = null,
    onDown: (() -> Unit)? = null
) {

    TvCreditsSection(
        title = "CAST",
        credits = casts,
        firstItemRequester = firstItemRequester,
        onUp = onUp,
        onDown = onDown
    )
}