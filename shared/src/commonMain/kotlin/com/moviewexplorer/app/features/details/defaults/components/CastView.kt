package com.moviewexplorer.app.features.details.defaults.components

import androidx.compose.runtime.Composable
import com.moviewexplorer.app.domain.model.CastAndCrew

@Composable
fun CastView(
    casts: List<CastAndCrew>
) {

    CreditsSection(
        title = "CAST",
        credits = casts
    )
}

