package com.moviewexplorer.app.features.listingScreen.tv.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens

@Composable
fun TvSearchEmptyState(
    modifier: Modifier = Modifier
) {

    val dimens = LocalTvDimens.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                dimens.screenPadding
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .background(
                    AppColors.Primary.copy(
                        alpha = 0.12f
                    )
                ),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.size(44.dp),
                tint = AppColors.Primary
            )
        }

        SpaceVertical(
            dimens.sectionSpacing
        )

        Text(
            text = "Search movies & TV shows",
            fontFamily = MontserratFontFamily(),
            fontSize = dimens.titleFont,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.TextPrimary,
            textAlign = TextAlign.Center
        )

        SpaceVertical(
            dimens.itemSpacing
        )

        Text(
            text = "Start typing to discover something to watch.",
            fontFamily = MontserratFontFamily(),
            fontSize = dimens.bodyFont,
            color = AppColors.TextSecondary,
            textAlign = TextAlign.Center
        )
    }
}