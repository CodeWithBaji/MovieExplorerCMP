package com.moviewexplorer.app.features.details.defaults.components.review

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType
import com.moviewexplorer.app.domain.model.Review

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewBottomSheet(
    review: Review,
    onDismiss: () -> Unit
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = AppColors.Surface,
        dragHandle = {
            BottomSheetDefaults.DragHandle(
                color = AppColors.TextSecondary.copy(alpha = 0.5f)
            )
        }
    ) {

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .then(
                        if (windowType == WindowType.Compact) {
                            Modifier
                        } else {
                            Modifier.widthIn(max = 700.dp)
                        }
                    )
                    .fillMaxHeight(0.90f)
                    .padding(
                        horizontal = dimens.screenPadding
                    )
                    .navigationBarsPadding()
            ) {

                Text(
                    text = "FULL REVIEW",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontFamily = MontserratFontFamily(),
                        fontSize = dimens.captionFont,
                        fontWeight = FontWeight.SemiBold,
                        color = AppColors.Primary
                    )
                )

                SpaceVertical(dimens.itemSpacing)

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

                SpaceVertical(dimens.sectionSpacing / 2)

                HorizontalDivider(
                    color = Color.White.copy(alpha = 0.08f)
                )

                SpaceVertical(dimens.sectionSpacing / 2)

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(
                            rememberScrollState()
                        )
                ) {

                    Text(
                        text = review.content.orEmpty(),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontFamily = MontserratFontFamily(),
                            fontSize = dimens.bodyFont,
                            fontWeight = FontWeight.Normal,
                            color = AppColors.TextSecondary,
                            lineHeight = dimens.bodyFont * 1.55f
                        )
                    )

                    SpaceVertical(dimens.sectionSpacing)
                }
            }
        }
    }
}