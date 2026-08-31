package com.moviewexplorer.app.features.home.tv.components

    import androidx.compose.foundation.focusGroup
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.PaddingValues
    import androidx.compose.foundation.lazy.LazyRow
    import androidx.compose.foundation.lazy.itemsIndexed
    import androidx.compose.foundation.lazy.rememberLazyListState
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.rememberCoroutineScope
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.focus.FocusRequester
    import androidx.compose.ui.focus.focusProperties
    import androidx.compose.ui.focus.focusRequester
    import com.moviewexplorer.app.core.components.SpaceVertical
    import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
    import com.moviewexplorer.app.core.utils.HomeRow
    import com.moviewexplorer.app.domain.model.Movie
    import kotlinx.coroutines.launch

@Composable
fun TvContentRow(
    title: String,
    movies: List<Movie>,
    firstItemRequester: FocusRequester,
    upRequester: FocusRequester? = null,
    downRequester: FocusRequester? = null,
    onMovieClick: (Int) -> Unit,
    onFirstCardFocused: (HomeRow) -> Unit = {},
    row: HomeRow
) {

    val dimens = LocalTvDimens.current
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    Column {

        TvHomeTitles(
            title = title
        )

        SpaceVertical(
            dimens.sectionSpacing / 2
        )

        LazyRow(
            state = listState,
            modifier = Modifier.focusGroup(),
            horizontalArrangement = Arrangement.spacedBy(
                dimens.itemSpacing
            ),
            contentPadding = PaddingValues(
                horizontal = dimens.screenPadding
            )
        ) {

            itemsIndexed(
                items = movies,
                key = { _, movie ->
                    movie.id
                }
            ) { index, movie ->

                TvCardsView(
                    movie = movie,

                    modifier = Modifier
                        .then(
                            if (index == 0) {
                                Modifier
                                    .focusRequester(
                                        firstItemRequester
                                    )
                                    .focusProperties {

                                        if (upRequester != null) {
                                            up = upRequester
                                        }

                                        if (downRequester != null) {
                                            down = downRequester
                                        }
                                    }
                            } else {
                                Modifier
                            }
                        ),

                    onDetailsScreen = onMovieClick,

                    onFocused = {

                        scope.launch {

                            when {

                                index >=
                                        listState.firstVisibleItemIndex + 4 -> {

                                    listState.animateScrollToItem(
                                        index - 2
                                    )
                                }

                                index <
                                        listState.firstVisibleItemIndex + 1 -> {

                                    listState.animateScrollToItem(
                                        maxOf(
                                            index - 1,
                                            0
                                        )
                                    )
                                }
                            }

                            if (index == 0) {
                                onFirstCardFocused(row)
                            }
                        }
                    }
                )
            }
        }
    }
}