package com.moviewexplorer.app.features.details.tv.components.reviews





import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.domain.model.Review

@Composable
fun TvReviewCard(
    review: Review,
    modifier: Modifier = Modifier,
    onUp: () -> Unit,
    onDown: () -> Unit,
    onOpen: (Review) -> Unit
) {

    var isFocused by remember {
        mutableStateOf(false)
    }

    val cardShape = RoundedCornerShape(20.dp)

    ElevatedCard(
        modifier = modifier
            .width(420.dp)
            .height(300.dp)
            .onFocusChanged { state ->
                isFocused = state.isFocused
            }.clickable {
                onOpen(review)
            }.onKeyEvent { event ->

                if (event.type != KeyEventType.KeyDown) {
                    return@onKeyEvent false
                }

                when (event.key) {

                    Key.DirectionUp -> {
                        onUp()
                        true
                    }

                    Key.DirectionDown -> {
                        onDown()
                        true
                    }

                    else -> false
                }
            }

            .focusable()
            .then(
                if (isFocused) {

                    Modifier.border(
                        width = 1.dp,
                        color = AppColors.Primary,
                        shape = cardShape
                    )

                } else {
                    Modifier
                }
            ),

        shape = cardShape,

        colors = CardDefaults.elevatedCardColors(
            containerColor = AppColors.Surface
        ),

        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 4.dp,
            focusedElevation = 10.dp
        )
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                TvAvatar(
                    name = review.name.orEmpty(),
                    avatarUrl = review.avatarPath,
                    size = 72.dp
                )

                Spacer(
                    modifier = Modifier.width(16.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = review.name
                            ?.takeIf { it.isNotBlank() }
                            ?: "Anonymous",

                        fontFamily = MontserratFontFamily(),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = AppColors.TextPrimary,

                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(
                        modifier = Modifier.height(5.dp)
                    )

                    Text(
                        text = review.date.orEmpty(),

                        fontFamily = MontserratFontFamily(),
                        fontSize = 14.sp,
                        color = AppColors.TextSecondary,

                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(
                    modifier = Modifier.width(12.dp)
                )

                review.rating?.let { rating ->

                    TvRatingBadge(
                        rating = rating
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(
                text = review.content.orEmpty(),

                fontFamily = MontserratFontFamily(),
                fontSize = 17.sp,
                color = AppColors.TextSecondary,

                lineHeight = 25.sp,

                maxLines = 5,
                overflow = TextOverflow.Ellipsis,

                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Text(
                text = "Read More  →",

                fontFamily = MontserratFontFamily(),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = AppColors.Primary
            )
        }
    }
}