package com.moviewexplorer.app.features.details.defaults.components.review

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.defaults.ReviewCardDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType
import com.moviewexplorer.app.domain.model.Review


@Composable
fun ReviewCard(
    review: Review,
    onReadMore: (Review) -> Unit
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    ElevatedCard(
        modifier = Modifier
            .width(ReviewCardDefaults.width(windowType))
            .height(ReviewCardDefaults.height(windowType)),
        shape = RoundedCornerShape(dimens.cornerLarge),
        colors = CardDefaults.elevatedCardColors(
            containerColor = AppColors.Surface
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimens.itemSpacing * 1.5f)
        ) {

            if (windowType == WindowType.Compact) {

                Column {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Avatar(
                            avatarPath = review.avatarPath,
                            name = review.name
                        )

                        SpacerHorizontal(dimens.itemSpacing)

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = review.name.orEmpty(),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontFamily = MontserratFontFamily(),
                                    fontSize = dimens.bodyFont,
                                    fontWeight = FontWeight.SemiBold,
                                    color = AppColors.TextPrimary
                                )
                            )

                            SpaceVertical(dimens.itemSpacing / 4)

                            Text(
                                text = review.date.orEmpty(),
                                maxLines = 1,
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontFamily = MontserratFontFamily(),
                                    fontSize = dimens.captionFont,
                                    fontWeight = FontWeight.Normal,
                                    color = AppColors.TextSecondary
                                )
                            )
                        }
                    }

                    SpaceVertical(dimens.itemSpacing)

                    RatingBadge(
                        review.rating ?: 0.0
                    )
                }

            } else {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Avatar(
                        avatarPath = review.avatarPath,
                        name = review.name
                    )

                    SpacerHorizontal(dimens.itemSpacing)

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = review.name.orEmpty(),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontFamily = MontserratFontFamily(),
                                fontSize = dimens.bodyFont,
                                fontWeight = FontWeight.SemiBold,
                                color = AppColors.TextPrimary
                            )
                        )

                        SpaceVertical(dimens.itemSpacing / 4)

                        Text(
                            text = review.date.orEmpty(),
                            maxLines = 1,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontFamily = MontserratFontFamily(),
                                fontSize = dimens.captionFont,
                                color = AppColors.TextSecondary
                            )
                        )
                    }

                    SpacerHorizontal(dimens.itemSpacing)

                    RatingBadge(
                        review.rating ?: 0.0
                    )
                }
            }

            SpaceVertical(dimens.itemSpacing * 1.5f)

            Text(
                text = review.content.orEmpty(),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = MontserratFontFamily(),
                    fontSize = dimens.bodyFont,
                    fontWeight = FontWeight.Normal,
                    color = AppColors.TextSecondary,
                    lineHeight = dimens.bodyFont * 1.45f
                )
            )

            Spacer(
                modifier = Modifier.weight(1f)
            )

            if ((review.content?.length ?: 0) > 100) {

                Row(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                dimens.cornerSmall
                            )
                        )
                        .clickable {
                            onReadMore(review)
                        }
                        .padding(
                            vertical = dimens.itemSpacing / 2
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Read More",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontFamily = MontserratFontFamily(),
                            fontSize = dimens.captionFont,
                            fontWeight = FontWeight.SemiBold,
                            color = AppColors.Primary
                        )
                    )

                    SpacerHorizontal(dimens.itemSpacing / 3)

                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = AppColors.Primary,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }
    }
}

