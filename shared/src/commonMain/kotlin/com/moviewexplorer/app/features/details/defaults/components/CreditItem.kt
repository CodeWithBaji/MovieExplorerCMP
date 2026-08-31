package com.moviewexplorer.app.features.details.defaults.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.defaults.CastCardDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.domain.model.CastAndCrew

@Composable
fun CreditItem(
    castAndCrew: CastAndCrew
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val roleTextColor =
        if (AppColors.Background.luminance() > 0.5f) {
            Color(0xFF62656C)
        } else {
            AppColors.TextSecondary
        }

    val imageSize = CastCardDefaults.imageSize(windowType)
    val cardWidth = CastCardDefaults.cardWidth(windowType)

    Column(
        modifier = Modifier.width(cardWidth),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(imageSize)
                .clip(CircleShape)
                .background(AppColors.Surface)
                .border(
                    width = 1.dp,
                    color = AppColors.Primary.copy(alpha = 0.75f),
                    shape = CircleShape
                )
        ) {

            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalPlatformContext.current)
                    .data(castAndCrew.profilePath)
                    .crossfade(true)
                    .crossfade(300)
                    .build(),
                contentDescription = castAndCrew.name,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                loading = {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(AppColors.Surface),
                        contentAlignment = Alignment.Center
                    ) {

                        CircularProgressIndicator(
                            modifier = Modifier.size(
                                imageSize * 0.25f
                            ),
                            strokeWidth = 2.dp,
                            color = AppColors.Primary
                        )
                    }
                },
                error = {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(AppColors.Surface),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = AppColors.TextSecondary,
                            modifier = Modifier.size(
                                imageSize * 0.45f
                            )
                        )
                    }
                }
            )
        }

        SpaceVertical(dimens.itemSpacing)

        Text(
            text = castAndCrew.name,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontFamily = MontserratFontFamily(),
                fontSize = dimens.bodyFont,
                fontWeight = FontWeight.SemiBold,
                color = AppColors.TextPrimary
            )
        )

        SpaceVertical(dimens.itemSpacing / 3)

        if (castAndCrew.character.isNotBlank()) {

            Text(
                text = castAndCrew.character,
                modifier = Modifier.fillMaxWidth(),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontFamily = MontserratFontFamily(),
                    fontSize = dimens.captionFont,
                    fontWeight = FontWeight.Normal,
                    color = roleTextColor,
                    lineHeight = dimens.captionFont * 1.35f
                )
            )
        }
    }
}