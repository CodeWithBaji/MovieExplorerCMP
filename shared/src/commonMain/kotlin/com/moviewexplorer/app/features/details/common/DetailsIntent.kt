package com.moviewexplorer.app.features.details.common

import com.moviewexplorer.app.core.utils.MediaType

sealed interface DetailsIntent {
    data class FetchDetailsData(val movieId: Int, val mediaType: MediaType) : DetailsIntent
    data object Retry: DetailsIntent
}