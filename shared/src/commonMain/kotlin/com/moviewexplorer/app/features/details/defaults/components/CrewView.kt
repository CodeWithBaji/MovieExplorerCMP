package com.moviewexplorer.app.features.details.defaults.components

import androidx.compose.runtime.Composable
import com.moviewexplorer.app.domain.model.CastAndCrew

@Composable
fun CrewView(
    crews: List<CastAndCrew>
) {

    CreditsSection(
        title = "CREW",
        credits = crews
    )
}