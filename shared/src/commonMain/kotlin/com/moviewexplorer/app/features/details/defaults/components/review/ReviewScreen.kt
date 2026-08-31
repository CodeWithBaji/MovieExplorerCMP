package com.moviewexplorer.app.features.details.defaults.components.review

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.domain.model.Review

@Composable
fun ReviewScreen(
    reviews: List<Review>
) {

    if (reviews.isEmpty()) return

    val dimens = LocalAppDimens.current

    var selectedReview by remember {
        mutableStateOf<Review?>(null)
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {


        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                horizontal = dimens.screenPadding
            ),
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {

            items(reviews) { review ->

                ReviewCard(
                    review = review,
                    onReadMore = {
                        selectedReview = it
                    }
                )
            }
        }
    }

    selectedReview?.let { review ->

        ReviewBottomSheet(
            review = review,
            onDismiss = {
                selectedReview = null
            }
        )
    }
}