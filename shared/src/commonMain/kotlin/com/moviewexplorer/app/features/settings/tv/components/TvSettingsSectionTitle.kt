package com.moviewexplorer.app.features.settings.tv.components



import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens

@Composable
fun TvSettingsSectionTitle(
    title: String
) {

    val dimens = LocalTvDimens.current

    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium.copy(
            fontFamily = MontserratFontFamily(),
            fontSize = dimens.sectionTitleFont,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.TextPrimary
        )
    )
}