package com.moviewexplorer.app.features.splash.defaults.components


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.BebasNeueFontFamily
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType


@Composable
fun SplashTitle(
    modifier: Modifier = Modifier
) {

    val windowType = LocalWindowType.current
    val dimens = LocalAppDimens.current

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "MOVIE EXPLORER",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontFamily = BebasNeueFontFamily(),
                fontSize = _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.defaults.SplashDefaults.titleFont(windowType),
                fontWeight = FontWeight.Bold,
                letterSpacing = _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.defaults.SplashDefaults.titleLetterSpacing(windowType),
                 color = AppColors.TextPrimary
            )
        )

        SpaceVertical(dimens.itemSpacing)

        Text(
            text = "Discover Movies & TV Shows",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontFamily = MontserratFontFamily(),
                fontSize = _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.defaults.SplashDefaults.subtitleFont(windowType),
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.5.sp,
                color = AppColors.TextSecondary
            )
        )
    }
}