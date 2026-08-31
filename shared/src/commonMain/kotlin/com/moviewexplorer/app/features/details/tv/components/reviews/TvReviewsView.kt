package com.moviewexplorer.app.features.details.tv.components.reviews


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.domain.model.Review

@Composable
fun TvReviewsView(
    reviews: List<Review>,
    firstItemRequester: FocusRequester,
    upRequester: () -> Unit,
    downRequester: () -> Unit,
    onOpen: (Review) -> Unit,
    modifier: Modifier = Modifier
) {


    val dimens = LocalTvDimens.current
    val montserrat = MontserratFontFamily()

    if (reviews.isEmpty()) {
        return
    }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .width(4.dp)
                        .height(24.dp)
                        .clip(RoundedCornerShape(50))
                        .background(AppColors.Primary)
                )

                SpacerHorizontal(dimens.itemSpacing)


                Text(
                    text = "REVIEWS",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontFamily = montserrat,
                        fontSize = dimens.sectionTitleFont,
                        fontWeight = FontWeight.SemiBold,
                        color = AppColors.TextPrimary
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Text(
                text = "View All",

                fontFamily = MontserratFontFamily(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = AppColors.Primary
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )


        LazyRow(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.spacedBy(20.dp),

            contentPadding = PaddingValues(
                start = 0.dp,
                end = 32.dp
            )
        ) {

            itemsIndexed(
                items = reviews,
                key = { index, review ->
                    "${review.name}_${review.date}_$index"
                }
            ) { index, review ->

                TvReviewCard(
                    review = review,

                    modifier = if (index == 0) {
                        Modifier.focusRequester(
                            firstItemRequester
                        )
                    } else {
                        Modifier
                    },

                    onUp = {


                        if (index == 0) {
                            upRequester()
                        }
                    },

                    onDown = {
                        downRequester()
                    },

                    onOpen = {
                        onOpen(it)
                    }
                )
            }
        }
    }
}