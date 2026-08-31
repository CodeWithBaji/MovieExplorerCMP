package com.moviewexplorer.app.features.splash.defaults.components



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashLogo(
    modifier: Modifier = Modifier
) {
    val windowType = LocalWindowType.current

    Image(
        painter = painterResource(Res.drawable.movie_explorer_logo),
        contentDescription = "Movie Explorer Logo",
        modifier = modifier
            .size(
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.defaults.SplashDefaults.logoSize(windowType)
        )
    )
}