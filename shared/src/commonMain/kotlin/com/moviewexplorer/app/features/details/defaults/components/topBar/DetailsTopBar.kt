package com.moviewexplorer.app.features.details.defaults.components.topBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.moviewexplorer.app.core.designsystem.ui.defaults.BackButtonDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType

@Composable
fun DetailsTopBar(
    elevated: Boolean,
    onBackPress: () -> Unit,
    title: String? = null,
    showSearchBar: Boolean = false,
    searchQuery: String = "",
    searchPlaceholder: String = "Search movies...",
    onSearchQueryChange: (String) -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppColors.Background)
            .statusBarsPadding()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.toolbarHeight)
                .padding(horizontal = dimens.screenPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {

            BackButton(
                circleSize = BackButtonDefaults.circleSize(windowType),
                arrowSize = BackButtonDefaults.arrowSize(windowType),
                onClick = onBackPress
            )

            SpacerHorizontal(dimens.itemSpacing)

            if (showSearchBar) {

                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = dimens.searchBarHeight),
                    singleLine = true,

                    textStyle = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = MontserratFontFamily(),
                        fontSize = dimens.bodyFont,
                        lineHeight = dimens.bodyFont * 1.2f,
                        fontWeight = FontWeight.Medium,
                        color = AppColors.TextPrimary
                    ),

                    placeholder = {
                        Text(
                            text = searchPlaceholder,
                            maxLines = 1,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontFamily = MontserratFontFamily(),
                                fontSize = dimens.bodyFont,
                                lineHeight = dimens.bodyFont * 1.2f,
                                fontWeight = FontWeight.Medium,
                                color = AppColors.TextSecondary
                            )
                        )
                    },


                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = AppColors.TextSecondary,
                            modifier = Modifier.size(20.dp)
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
                                    tint = AppColors.TextSecondary,
                                    modifier = Modifier.size(20.dp)
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

                    shape = RoundedCornerShape(50),

                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = AppColors.Surface,
                        unfocusedContainerColor = AppColors.Surface,
                        focusedBorderColor = Color.White.copy(alpha = 0.15f),
                        unfocusedBorderColor = Color.White.copy(alpha = 0.08f),
                        cursorColor = AppColors.Primary,
                        focusedTextColor = AppColors.TextPrimary,
                        unfocusedTextColor = AppColors.TextPrimary,
                        focusedPlaceholderColor = AppColors.TextSecondary,
                        unfocusedPlaceholderColor = AppColors.TextSecondary
                    )
                )

            } else {

                Text(
                    text = title.orEmpty(),
                    modifier = Modifier.weight(1f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontFamily = MontserratFontFamily(),
                        color = AppColors.TextPrimary,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = dimens.sectionTitleFont
                    )
                )

                actions()
            }
        }
    }
}