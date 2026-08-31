package com.moviewexplorer.app.features.details.tv.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens

@Composable
fun TvDetailTitles(
    title: String,
    showViewAll: Boolean = false,
    onViewAllClick: () -> Unit = {}
) {

    val dimens = LocalTvDimens.current
    val montserrat = MontserratFontFamily()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimens.screenPadding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier.weight(1f),
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
                text = title,
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

        if (showViewAll) {

            SpacerHorizontal(dimens.itemSpacing)

            Text(
                text = "View All",
                modifier = Modifier.clickable {
                    onViewAllClick()
                },
                style = MaterialTheme.typography.labelMedium.copy(
                    fontFamily = montserrat,
                    fontSize = dimens.bodyFont,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.PrimaryLight
                )
            )
        }
    }
}