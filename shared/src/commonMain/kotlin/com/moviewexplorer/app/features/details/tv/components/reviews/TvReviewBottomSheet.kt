package com.moviewexplorer.app.features.details.tv.components.reviews




import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.domain.model.Review

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvReviewBottomSheet(
    review: Review,
    onDismiss: () -> Unit
) {

    val dimens = LocalTvDimens.current

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    val scrollState = rememberScrollState()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = AppColors.Background,
        tonalElevation = 0.dp
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.90f)
                .verticalScroll(scrollState)

                .onKeyEvent { event ->

                    if (event.type != KeyEventType.KeyDown) {
                        return@onKeyEvent false
                    }

                    when (event.key) {

                        Key.DirectionDown -> {
                            scrollState.dispatchRawDelta(120f)
                            true
                        }

                        Key.DirectionUp -> {
                            scrollState.dispatchRawDelta(-120f)
                            true
                        }

                        else -> false
                    }
                }

                .focusable()

                .padding(
                    horizontal = dimens.screenPadding,
                    vertical = dimens.sectionSpacing
                )
        ) {



            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(AppColors.Surface),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = review.name
                            ?.takeIf { it.isNotBlank() }
                            ?.first()
                            ?.uppercase()
                            ?: "A",

                        fontFamily = MontserratFontFamily(),
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Medium,
                        color = AppColors.TextPrimary
                    )
                }

                SpacerHorizontal(
                    dimens.itemSpacing
                )

                // Name + Date
                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = review.name
                            ?.takeIf { it.isNotBlank() }
                            ?: "Anonymous",

                        fontFamily = MontserratFontFamily(),
                        fontSize = dimens.bodyFont,
                        fontWeight = FontWeight.SemiBold,

                        color = AppColors.TextPrimary
                    )

                    SpaceVertical(6.dp)

                    Text(
                        text = review.date.orEmpty(),

                        fontFamily = MontserratFontFamily(),
                        fontSize = dimens.captionFont,
                        fontWeight = FontWeight.Normal,

                        color = AppColors.TextSecondary
                    )
                }

                // Rating
                review.rating?.let { rating ->

                    TvRatingBadge(
                        rating = rating
                    )
                }
            }

            SpaceVertical(
                dimens.sectionSpacing
            )


            Text(
                text = review.content.orEmpty(),

                modifier = Modifier.fillMaxWidth(),

                fontFamily = MontserratFontFamily(),
                fontSize = dimens.bodyFont,
                fontWeight = FontWeight.Normal,

                color = AppColors.TextPrimary,

                lineHeight = dimens.bodyFont * 1.6f
            )

            SpaceVertical(
                dimens.sectionSpacing
            )
        }
    }
}