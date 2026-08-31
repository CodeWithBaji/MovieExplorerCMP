package com.moviewexplorer.app.features.home.tv.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.domain.model.Movie
import com.moviewexplorer.app.features.home.defaults.components.CardsView

@Composable
fun TvContentCards(
    movies: List<Movie>,
    onDetailsScreen: (id: Int) -> Unit){

    val dimens = LocalTvDimens.current

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = dimens.screenPadding),
        horizontalArrangement = Arrangement.spacedBy(dimens.cardSpacing)
    ) {

        items(movies) {

            CardsView(
                it, onDetailsScreen = { id ->
                    onDetailsScreen(id)
                })
        }
    }
}