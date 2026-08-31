package com.moviewexplorer.app.features.listingScreen.tv.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.core.utils.safeRequestFocus

@Composable
fun TvListingMediaSelector(
    selectedMediaType: MediaType,

    moviesRequester: FocusRequester,
    tvRequester: FocusRequester,
    firstCardRequester: FocusRequester,

    onMediaTypeSelected: (MediaType) -> Unit
) {

    val dimens = LocalTvDimens.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimens.screenPadding,
                vertical = dimens.itemSpacing
            )
            .clip(
                RoundedCornerShape(
                    dimens.cornerMedium
                )
            )
            .background(
                AppColors.Surface
            )
            .border(
                1.dp,
                AppColors.Border.copy(alpha = 0.5f),
                RoundedCornerShape(
                    dimens.cornerMedium
                )
            )
            .padding(4.dp)
    ) {



        TvListingMediaOption(
            title = "Movies",

            selected = selectedMediaType == MediaType.MOVIE,

            modifier = Modifier
                .weight(1f)
                .focusRequester(moviesRequester)
                .focusProperties {
                    right = tvRequester
                    down = firstCardRequester
                }
                .onPreviewKeyEvent { event ->

                    if (event.type != KeyEventType.KeyDown) {
                        return@onPreviewKeyEvent false
                    }

                    when (event.key) {

                        Key.DirectionRight -> {

                            onMediaTypeSelected(
                                MediaType.TV
                            )

                            tvRequester.safeRequestFocus()

                            true
                        }

                        Key.DirectionDown -> {

                            firstCardRequester.safeRequestFocus()

                            true
                        }

                        else -> false
                    }
                },

            onClick = {

                onMediaTypeSelected(
                    MediaType.MOVIE
                )

                moviesRequester.safeRequestFocus()
            }
        )



        TvListingMediaOption(
            title = "TV Shows",

            selected = selectedMediaType == MediaType.TV,

            modifier = Modifier
                .weight(1f)
                .focusRequester(tvRequester)
                .focusProperties {
                    left = moviesRequester
                    down = firstCardRequester
                }
                .onPreviewKeyEvent { event ->

                    if (event.type != KeyEventType.KeyDown) {
                        return@onPreviewKeyEvent false
                    }

                    when (event.key) {

                        Key.DirectionLeft -> {

                            onMediaTypeSelected(
                                MediaType.MOVIE
                            )

                            moviesRequester.safeRequestFocus()

                            true
                        }

                        Key.DirectionDown -> {

                            firstCardRequester.safeRequestFocus()

                            true
                        }

                        else -> false
                    }
                },

            onClick = {

                onMediaTypeSelected(
                    MediaType.TV
                )

                tvRequester.safeRequestFocus()
            }
        )
    }
}