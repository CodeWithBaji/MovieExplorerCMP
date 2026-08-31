package com.moviewexplorer.app.features.home.tv

import androidx.compose.runtime.Stable
import androidx.compose.ui.focus.FocusRequester

@Stable
class TvHomeFocusState {

    // Top bar
    val topBar = FocusRequester()
    val trending = FocusRequester()
    val popular = FocusRequester()
    val topRated = FocusRequester()
    val search = FocusRequester()
    val settings = FocusRequester()

    // Banner
    val watchNow = FocusRequester()

    // Content rows
    val popularMovie = FocusRequester()
    val popularTv = FocusRequester()
    val topRatedMovies = FocusRequester()
    val topRatedTv = FocusRequester()
    val watchListMovies = FocusRequester()
    val watchListTvShows = FocusRequester()
}