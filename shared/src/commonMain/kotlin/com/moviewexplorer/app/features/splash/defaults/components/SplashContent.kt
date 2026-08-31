package com.moviewexplorer.app.features.splash.defaults.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.defaults.SplashDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.features.splash.common.LoadingBar
import kotlinx.coroutines.delay

@Composable
fun SplashContent(
    onSplashFinished: () -> Unit
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    LaunchedEffect(Unit) {
        delay(3000)
        onSplashFinished()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        AnimatedBackground()

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-24).dp), // Slightly higher for better visual balance
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                contentAlignment = Alignment.Center
            ) {

                AnimatedGlow()

                SplashLogo()
            }

            SpaceVertical(dimens.sectionSpacing)

            SplashTitle()
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .widthIn(max = SplashDefaults.loadingWidth(windowType))
                .fillMaxWidth()
                .padding(
                    horizontal = dimens.screenPadding,
                    vertical = dimens.sectionSpacing
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LoadingBar()

            SpaceVertical(dimens.itemSpacing)

            LoadingText()
        }
    }
}