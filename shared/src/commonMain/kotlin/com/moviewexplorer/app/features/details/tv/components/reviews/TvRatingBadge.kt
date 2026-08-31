package com.moviewexplorer.app.features.details.tv.components.reviews



import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens

@Composable
fun TvRatingBadge(
    rating: Double,
    modifier: Modifier = Modifier
) {

    val dimens = LocalTvDimens.current

    val value = ((rating * 10).toInt() / 10.0).toString()

    Row(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    dimens.cornerSmall
                )
            )
            .border(
                width = 1.dp,
                color = AppColors.Rating,
                shape = RoundedCornerShape(
                    dimens.cornerSmall
                )
            )
            .padding(
                horizontal = 12.dp,
                vertical = 6.dp
            ),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            tint = AppColors.Rating,
            modifier = Modifier.size(18.dp)
        )

        SpacerHorizontal(6.dp)

        Text(
            text = "$value/10",
            fontFamily = MontserratFontFamily(),
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.TextPrimary
        )
    }
}