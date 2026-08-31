package com.moviewexplorer.app.features.splash.tv.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.BebasNeueFontFamily
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.defaults.tv.TvSplashDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvWindowType

@Composable
fun TvSplashTitle(
    modifier: Modifier = Modifier
){
    val windowType = LocalTvWindowType.current
    val dimens = LocalTvDimens.current

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "MOVIE EXPLORER",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontFamily = BebasNeueFontFamily(),
                fontSize = TvSplashDefaults.titleFont(windowType),
                fontWeight = FontWeight.Normal,
                letterSpacing = TvSplashDefaults.titleLetterSpacing(windowType),
                color = AppColors.TextPrimary
            )
        )

        SpaceVertical(20.dp)

        Text(
            text = "Discover Movies & TV Shows",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontFamily = MontserratFontFamily(),
                fontSize = TvSplashDefaults.subtitleFont(windowType),
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.5.sp,
                color = AppColors.TextSecondary
            )
        )
    }
}