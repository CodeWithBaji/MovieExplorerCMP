package com.moviewexplorer.app.features.home.defaults.components.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.BebasNeueFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

@Composable
 fun TopBarBrand() {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(
                Res.drawable.movie_explorer_logo
            ),
            contentDescription = "Movie Explorer",
            modifier = Modifier.size(dimens.logoSize)
        )

        SpacerHorizontal(dimens.itemSpacing)

        Text(
            text = "MOVIE EXPLORER",
            style = MaterialTheme.typography.titleLarge.copy(
                fontFamily = BebasNeueFontFamily(),
                fontSize = when (windowType) {
                    WindowType.Compact -> 22.sp
                    WindowType.Medium -> 24.sp
                    WindowType.Expanded -> 27.sp
                },
                fontWeight = FontWeight.Normal,
                letterSpacing = 1.2.sp,
                color = AppColors.TextPrimary
            ),
            maxLines = 1
        )
    }
}