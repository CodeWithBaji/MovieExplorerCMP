package com.moviewexplorer.app.features.details.tv.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.domain.model.Movie
import com.moviewexplorer.app.features.home.tv.components.TvCardsView
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import com.moviewexplorer.app.core.utils.safeRequestFocus

@Composable
fun TvSimilarMoviesView(
    movies: List<Movie>,
    firstItemRequester: FocusRequester,
    upRequester: FocusRequester? = null,
    downRequester: FocusRequester? = null,
    onMovieClick: (id: Int) -> Unit
) {

    if (movies.isEmpty()) return

    val dimens = LocalTvDimens.current

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        TvDetailTitles(
            title = "SIMILAR MOVIES",
            showViewAll = true,
            onViewAllClick = {
                // TODO: Open similar movies listing
            }
        )

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
                items = movies,
                key = { movie ->
                    movie.id
                }
            ) { movie ->

                val index = movies.indexOf(movie)

                TvCardsView(
                    movie = movie,

                    modifier = Modifier
                        .then(
                            if (index == 0) {
                                Modifier.focusRequester(
                                    firstItemRequester
                                )
                            } else {
                                Modifier
                            }
                        )
                        .focusProperties {

                            upRequester?.let {
                                up = it
                            }
                        }
                        .onPreviewKeyEvent { event ->

                            if (event.type == KeyEventType.KeyDown &&
                                event.key == Key.DirectionDown
                            ) {
                                downRequester?.safeRequestFocus() == true
                            } else {
                                false
                            }
                        },

                    onDetailsScreen = onMovieClick
                )
            }
        }
    }
}