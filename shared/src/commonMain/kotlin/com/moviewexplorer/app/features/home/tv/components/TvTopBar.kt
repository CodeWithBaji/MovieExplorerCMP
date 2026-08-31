package com.moviewexplorer.app.features.home.tv.components


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun TvTopBar(
    focusRequester: FocusRequester,
    downRequester: FocusRequester,

    trendingRequester: FocusRequester,
    popularRequester: FocusRequester,
    topRatedRequester: FocusRequester,
    searchRequester: FocusRequester,
    settingsRequester: FocusRequester,

    onHomeClick: () -> Unit = {},
    onTrendingClick: () -> Unit,
    onPopularClick: () -> Unit,
    onTopRatedClick: () -> Unit,
    onSearchClick: () -> Unit,
    onSettingsClick: () -> Unit = {},

    onInitialFocusRequested: () -> Unit,
    requestInitialFocus: Boolean
) {

    val dimens = LocalTvDimens.current

    var logoFocused by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(requestInitialFocus) {
        if (requestInitialFocus) {
            focusRequester.requestFocus()
            onInitialFocusRequested()
        }
    }

    val logoScale by animateFloatAsState(
        targetValue = if (logoFocused) {
            1.02f
        } else {
            1f
        },
        label = "LogoScale"
    )


    val logoTextColor by animateColorAsState(
        targetValue = if (logoFocused) {
            AppColors.Primary
        } else {
            AppColors.TextPrimary
        },
        label = "LogoTextColor"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimens.topBarHeight)
            .padding(horizontal = dimens.horizontalPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {



        Row(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = logoScale
                    scaleY = logoScale
                }
                .focusRequester(focusRequester)
                .focusProperties {
                    right = trendingRequester
                    down = downRequester
                }
                .onFocusChanged {
                    logoFocused = it.isFocused
                }
                .focusable()
                .clickable(
                    onClick = onHomeClick
                )
                .padding(
                    vertical = dimens.itemSpacing / 2
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(
                    Res.drawable.movie_explorer_logo
                ),
                contentDescription = "Movie Explorer",
                modifier = Modifier.size(
                    dimens.logoSize
                )
            )

            SpacerHorizontal(
                dimens.itemSpacing
            )

            Text(
                text = "MOVIE EXPLORER",
                color = logoTextColor,
                fontFamily = MontserratFontFamily(),
                fontWeight = FontWeight.Bold,
                fontSize = dimens.sectionTitleFont,
                maxLines = 1
            )
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )



        TvTopBarTextButton(
            text = "Trending",
            modifier = Modifier
                .focusRequester(trendingRequester)
                .focusProperties {
                    left = focusRequester
                    right = popularRequester
                    down = downRequester
                },
            onClick = onTrendingClick
        )

        SpacerHorizontal(
            dimens.buttonSpacing
        )



        TvTopBarTextButton(
            text = "Popular",
            modifier = Modifier
                .focusRequester(popularRequester)
                .focusProperties {
                    left = trendingRequester
                    right = topRatedRequester
                    down = downRequester
                },
            onClick = onPopularClick
        )

        SpacerHorizontal(
            dimens.buttonSpacing
        )



        TvTopBarTextButton(
            text = "Top Rated",
            modifier = Modifier
                .focusRequester(topRatedRequester)
                .focusProperties {
                    left = popularRequester
                    right = searchRequester
                    down = downRequester
                },
            onClick = onTopRatedClick
        )

        SpacerHorizontal(
            dimens.buttonSpacing
        )



        TvTopBarButton(
            text = "Search",
            icon = Icons.Default.Search,
            modifier = Modifier
                .focusRequester(searchRequester)
                .focusProperties {
                    left = topRatedRequester
                    right = settingsRequester
                    down = downRequester
                },
            onClick = onSearchClick
        )

        SpacerHorizontal(
            dimens.buttonSpacing
        )



        TvTopBarButton(
            text = "Settings",
            icon = Icons.Default.Settings,
            modifier = Modifier
                .focusRequester(settingsRequester)
                .focusProperties {
                    left = searchRequester
                    down = downRequester
                },
            onClick = {
                onSettingsClick()
            }
        )
    }
}