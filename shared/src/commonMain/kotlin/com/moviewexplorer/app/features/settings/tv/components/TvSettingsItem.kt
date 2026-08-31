package com.moviewexplorer.app.features.settings.tv.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily

@Composable
fun TvSettingsItem(
    title: String,
    trailingText: String? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 10.dp,
                vertical = 18.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            color = AppColors.TextPrimary,
            fontFamily = MontserratFontFamily(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 1
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        if (trailingText != null) {
            Text(
                text = trailingText,
                color = AppColors.TextSecondary,
                fontFamily = MontserratFontFamily(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )

            SpacerHorizontal(12.dp)
        }

        Text(
            text = "›",
            color = AppColors.TextSecondary,
            fontSize = 30.sp,
            fontWeight = FontWeight.Normal
        )
    }
}