package com.moviewexplorer.app.features.splash.defaults.components



import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.defaults.SplashDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType


@Composable
fun LoadingText() {

    val windowType = LocalWindowType.current

    Text(
        text = "Loading your cinema...",
        style = MaterialTheme.typography.bodyMedium.copy(
            fontFamily = MontserratFontFamily(),
            fontSize = SplashDefaults.subtitleFont(windowType),
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.5.sp,
            color = AppColors.TextTertiary
        )
    )
}