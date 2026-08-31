package com.moviewexplorer.app.features.home.defaults.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
fun ExploreItem(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    onClick: () -> Unit
) {

    val dimens = LocalAppDimens.current

    Surface(
        modifier = modifier
            .height(80.dp)
            .clip(
                RoundedCornerShape(dimens.cornerMedium)
            )
            .clickable(onClick = onClick),
        color = AppColors.Surface,
        border = BorderStroke(
            1.dp,
            Color.White.copy(alpha = 0.06f)
        )
    ) {

        Column(
            modifier = Modifier.padding(
                dimens.itemSpacing
            ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = AppColors.Primary,
                modifier = Modifier.size(22.dp)
            )

            SpaceVertical(dimens.itemSpacing / 2)

            Text(
                text = title,
                maxLines = 1,
                style = MaterialTheme.typography.labelMedium.copy(
                    fontFamily = MontserratFontFamily(),
                    fontSize = dimens.captionFont,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.TextPrimary
                )
            )
        }
    }
}