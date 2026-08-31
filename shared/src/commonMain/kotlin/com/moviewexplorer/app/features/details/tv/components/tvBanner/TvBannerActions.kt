package com.moviewexplorer.app.features.details.tv.components.tvBanner

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.defaults.tv.TvBannerDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvWindowType

@Composable
fun TvBannerActions(
    watchRequester: FocusRequester,
    watchListRequester: FocusRequester,
    upRequester: FocusRequester,
    downRequester: FocusRequester,
    castRequester: FocusRequester,
    onWatchNow: () -> Unit = {},
    onWatchList: () -> Unit = {},
    onFocusChanged: (Boolean) -> Unit = {}
) {

    val dimens = LocalTvDimens.current
    val windowType = LocalTvWindowType.current

    var watchFocused by remember {
        mutableStateOf(false)
    }

    var watchListFocused by remember {
        mutableStateOf(false)
    }

    val watchScale by animateFloatAsState(
        targetValue = if (watchFocused) 1.05f else 1f,
        animationSpec = tween(150),
        label = "WatchScale"
    )

    val watchListScale by animateFloatAsState(
        targetValue = if (watchListFocused) 1.05f else 1f,
        animationSpec = tween(150),
        label = "WatchListScale"
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            dimens.itemSpacing
        )
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .focusRequester(watchRequester)
                .focusProperties {
                    up = upRequester
                    down = watchListRequester
                }
                .onFocusChanged {
                    watchFocused = it.isFocused
                    onFocusChanged(
                        it.isFocused || watchListFocused
                    )
                }
                .focusable()
                .clickable {
                    onWatchNow()
                }
                .height(
                    TvBannerDefaults.detailsButtonHeight(windowType)
                )
                .graphicsLayer {
                    scaleX = watchScale
                    scaleY = watchScale
                }
                .background(
                    Color.Red,
                    RoundedCornerShape(dimens.cornerSmall)
                ),
            contentAlignment = Alignment.Center
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = Color.White
                )

                SpacerHorizontal(dimens.itemSpacing)

                Text(
                    text = "Watch Now",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = dimens.bodyFont,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                )
            }
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .focusRequester(watchListRequester)
                .focusProperties {
                    up = watchRequester
                    down = castRequester
                }
                .onFocusChanged {
                    watchListFocused = it.isFocused
                    onFocusChanged(
                        it.isFocused || watchFocused
                    )
                }
                .focusable()
                .clickable {
                    onWatchList()
                }
                .height(
                    TvBannerDefaults.detailsButtonHeight(windowType)
                )
                .graphicsLayer {
                    scaleX = watchListScale
                    scaleY = watchListScale
                }
                .background(
                    color = AppColors.SurfaceElevated,
                    shape = RoundedCornerShape(
                        dimens.cornerMedium
                    )
                )
                .border(
                    BorderStroke(
                        0.5.dp,
                        Color.LightGray
                    ),
                    RoundedCornerShape(dimens.cornerSmall)
                ),
            contentAlignment = Alignment.Center
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Outlined.Bookmark,
                    contentDescription = null,
                    tint = if (watchListFocused) {
                        AppColors.Primary
                    } else {
                        AppColors.TextPrimary
                    }
                )

                SpacerHorizontal(dimens.itemSpacing)

                Text(
                    text = "Add To Watchlist",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = dimens.bodyFont,
                        fontWeight = FontWeight.SemiBold,
                        color = if (watchListFocused) {
                            AppColors.Primary
                        } else {
                            AppColors.TextPrimary
                        }
                    )
                )
            }
        }
    }
}