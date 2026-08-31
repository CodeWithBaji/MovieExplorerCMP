package com.moviewexplorer.app.core.components.shimmers.tv

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TvShimmerBox(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.shimmer()
    )
}