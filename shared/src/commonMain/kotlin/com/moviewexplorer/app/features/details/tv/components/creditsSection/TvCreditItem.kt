package com.moviewexplorer.app.features.details.tv.components.creditsSection

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
import com.moviewexplorer.app.core.designsystem.ui.defaults.tv.TvCastCardDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvWindowType
import com.moviewexplorer.app.domain.model.CastAndCrew
import kotlinx.coroutines.launch

@Composable
fun TvCreditItem(
    castAndCrew: CastAndCrew,
    modifier: Modifier = Modifier
) {

    val dimens = LocalTvDimens.current
    val windowType = LocalTvWindowType.current

    val roleTextColor =
        if (AppColors.Background.luminance() > 0.5f) {
            Color(0xFF62656C)
        } else {
            AppColors.TextSecondary
        }

    val imageSize = TvCastCardDefaults.imageSize(windowType)
    val cardWidth = TvCastCardDefaults.cardWidth(windowType)

    val bringIntoViewRequester = remember {
        BringIntoViewRequester()
    }

    val coroutineScope = rememberCoroutineScope()

    var isFocused by remember {
        mutableStateOf(false)
    }

    val scale by animateFloatAsState(
        targetValue = if (isFocused) 1.08f else 1f,
        animationSpec = tween(150),
        label = "CreditItemScale"
    )

    Column(
        modifier = modifier
            .width(cardWidth)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .bringIntoViewRequester(
                bringIntoViewRequester
            )
            .onFocusChanged { focusState ->

                isFocused = focusState.isFocused

                if (focusState.isFocused) {
                    coroutineScope.launch {
                        bringIntoViewRequester.bringIntoView()
                    }
                }
            }
            .focusable(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(imageSize)
                .clip(CircleShape)
                .background(AppColors.Surface)
                .border(
                    width = if (isFocused) 2.dp else 1.dp,
                    color = if (isFocused) {
                        AppColors.Primary
                    } else {
                        AppColors.Primary.copy(alpha = 0.75f)
                    },
                    shape = CircleShape
                )
        ) {

            SubcomposeAsyncImage(
                model = ImageRequest.Builder(
                    LocalPlatformContext.current
                )
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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        TvCastCardDefaults.roleHeight(windowType)
                    ),
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