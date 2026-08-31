package com.moviewexplorer.app.features.listingScreen.defaults.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType
import com.moviewexplorer.app.domain.model.Movie
import com.moviewexplorer.app.features.home.defaults.components.CardsView

@Composable
fun ListingContentSection(
    movies: List<Movie>,
    onDetailsScreen: (Int) -> Unit
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val columns = when (windowType) {
        WindowType.Compact -> 2
        WindowType.Medium -> 4
        WindowType.Expanded -> 6
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimens.cardSpacing),
        verticalArrangement = Arrangement.spacedBy(dimens.sectionSpacing),
        contentPadding = PaddingValues(
            horizontal = dimens.screenPadding,
            vertical = dimens.sectionSpacing
        )
    ) {

        items(
            items = movies,
            key = { it.id }
        ) { movie ->

            CardsView(
                movie = movie,
                modifier = Modifier.fillMaxWidth(),
                onDetailsScreen = onDetailsScreen
            )
        }
    }
}