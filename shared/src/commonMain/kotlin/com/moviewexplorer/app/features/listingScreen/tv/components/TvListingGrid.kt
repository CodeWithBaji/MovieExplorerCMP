package com.moviewexplorer.app.features.listingScreen.tv.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.domain.model.Movie

@Composable
fun TvListingGrid(
    movies: List<Movie>,
    onDetailsScreen: (id: Int, mediaType: MediaType) -> Unit,
    modifier: Modifier = Modifier
) {

    val dimens = LocalTvDimens.current

    val columns = 7

    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        movies.chunked(columns).forEach { row ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = dimens.screenPadding
                    ),
                horizontalArrangement = Arrangement.spacedBy(
                    dimens.cardSpacing
                )
            ) {

                row.forEach { movie ->

                    TvListingCard(
                        movie = movie,
                        modifier = Modifier.weight(1f),
                        onClick = {

                            val mediaType =
                                when (movie.mediaType) {

                                    "movie" ->
                                        MediaType.MOVIE

                                    "tv" ->
                                        MediaType.TV

                                    else ->
                                        MediaType.MOVIE
                                }

                            onDetailsScreen(
                                movie.id,
                                mediaType
                            )
                        }
                    )
                }


                repeat(columns - row.size) {

                    Spacer(
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            SpaceVertical(
                dimens.sectionSpacing
            )
        }
    }
}