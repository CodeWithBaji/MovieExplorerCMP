    package com.moviewexplorer.app.features.splash.tv.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.ui.defaults.tv.TvSplashDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvWindowType
import com.moviewexplorer.app.features.splash.common.LoadingBar
import kotlinx.coroutines.delay

    @Composable
fun TvSplashContent(
    onSplashFinished: () -> Unit
) {

    val windowType = LocalTvWindowType.current

    LaunchedEffect(Unit) {
        delay(3000)
        onSplashFinished()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        TvAnimatedBackground()

        // Logo stays centered
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-120).dp),
            contentAlignment = Alignment.Center
        ) {

            TvAnimatedGlow(
                modifier = Modifier
                    .size(
                        TvSplashDefaults.logoGlowSize(windowType)
                    )
                    .align(Alignment.Center)
            )

            TvSplashLogo()
        }

        // Bottom content
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(
                    bottom = 50.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TvSplashTitle()

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            LoadingBar(
                modifier = Modifier.width(
                    TvSplashDefaults.loadingWidth(windowType)
                )
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            TvLoadingText()
        }
    }
}