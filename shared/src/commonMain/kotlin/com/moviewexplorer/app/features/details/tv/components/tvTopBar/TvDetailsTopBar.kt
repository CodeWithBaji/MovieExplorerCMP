package com.moviewexplorer.app.features.details.tv.components.tvTopBar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.BackButton
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.defaults.tv.TvBackButtonDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvWindowType

@Composable
fun TvDetailsTopBar(
    elevated: Boolean,
    onBackPress: () -> Unit,
    title: String? = null,
    showSearchBar: Boolean = false,
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    focusRequester: FocusRequester,
    downRequester: FocusRequester
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val dimens = LocalTvDimens.current
    val windowType = LocalTvWindowType.current

    val backgroundColor by animateColorAsState(
        targetValue = if (elevated) {
            AppColors.Background.copy(alpha = 0.97f)
        } else {
            AppColors.Background.copy(alpha = 0.92f)
        },
        animationSpec = tween(200),
        label = "DetailsTopBarBackground"
    )

    val elevation by animateDpAsState(
        targetValue = if (elevated) 6.dp else 0.dp,
        animationSpec = tween(200),
        label = "DetailsTopBarElevation"
    )

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = backgroundColor,
        tonalElevation = elevation,
        shadowElevation = elevation
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.topBarHeight)
                .padding(
                    horizontal = dimens.screenPadding
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            /*
             * Back Button
             */
            BackButton(
                circleSize = TvBackButtonDefaults.circleSize(windowType),
                arrowSize = TvBackButtonDefaults.arrowSize(windowType),

                onClick = onBackPress,

                modifier = Modifier
                    .focusRequester(focusRequester)
                    .focusProperties {
                        down = downRequester
                    }
            )

            SpacerHorizontal(
                dimens.itemSpacing
            )

            /*
             * Search
             */
            if (showSearchBar) {

                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,

                    modifier = Modifier.weight(1f),

                    singleLine = true,

                    placeholder = {
                        Text(
                            text = "Search movies...",

                            fontFamily = MontserratFontFamily(),
                            fontWeight = FontWeight.Medium,
                            fontSize = dimens.bodyFont,

                            color = AppColors.TextTertiary
                        )
                    },

                    leadingIcon = {

                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",

                            tint = AppColors.TextSecondary
                        )
                    },

                    trailingIcon = {

                        if (searchQuery.isNotEmpty()) {

                            IconButton(
                                onClick = {
                                    onSearchQueryChange("")
                                }
                            ) {

                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Clear Search",

                                    tint = AppColors.TextSecondary
                                )
                            }
                        }
                    },

                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Search
                    ),

                    keyboardActions = KeyboardActions(
                        onSearch = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }
                    ),

                    shape = RoundedCornerShape(
                        50
                    ),

                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = AppColors.Surface,
                        unfocusedContainerColor = AppColors.Surface,

                        focusedBorderColor = AppColors.FocusBorder,
                        unfocusedBorderColor = AppColors.Border,

                        cursorColor = AppColors.Primary,

                        focusedTextColor = AppColors.TextPrimary,
                        unfocusedTextColor = AppColors.TextPrimary,

                        focusedPlaceholderColor = AppColors.TextTertiary,
                        unfocusedPlaceholderColor = AppColors.TextTertiary
                    )
                )

            } else {

                /*
                 * Screen Title
                 */
                Text(
                    text = title.orEmpty(),

                    modifier = Modifier.weight(1f),

                    fontFamily = MontserratFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = dimens.sectionTitleFont,

                    color = AppColors.TextPrimary,

                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                /*
                 * Right-side Actions
                 */
                actions()
            }
        }
    }
}