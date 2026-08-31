package com.moviewexplorer.app.features.splash.tv.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.defaults.tv.TvSplashDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvWindowType

@Composable
fun TvLoadingText() {

    val windowType = LocalTvWindowType.current

    Text(
        text = "Loading your cinema...",
        style = MaterialTheme.typography.bodyMedium.copy(
            fontFamily = MontserratFontFamily(),
            fontSize = TvSplashDefaults.subtitleFont(windowType),
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.5.sp,
            color = AppColors.TextSecondary
        )
    )
}