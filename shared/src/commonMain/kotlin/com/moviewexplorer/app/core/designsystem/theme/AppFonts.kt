package com.moviewexplorer.app.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.bebas_neue
import movieexplorer.shared.generated.resources.montserrat_medium
import movieexplorer.shared.generated.resources.montserrat_semibold
import org.jetbrains.compose.resources.Font

@Composable
fun BebasNeueFontFamily() = FontFamily(
    Font(
        resource = Res.font.bebas_neue,
        weight = FontWeight.Normal
    )
)

@Composable
fun MontserratFontFamily() = FontFamily(
    Font(
        resource = Res.font.montserrat_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resource = Res.font.montserrat_semibold,
        weight = FontWeight.SemiBold
    )
)