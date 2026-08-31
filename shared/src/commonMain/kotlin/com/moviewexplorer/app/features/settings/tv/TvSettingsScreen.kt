package com.moviewexplorer.app.features.settings.tv


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.features.details.tv.components.tvTopBar.TvDetailsTopBar
import com.moviewexplorer.app.features.settings.defaults.components.theme.AppThemeMode
import com.moviewexplorer.app.features.settings.tv.components.TvSettingsFocusState
import com.moviewexplorer.app.features.settings.tv.components.TvSettingsItem
import com.moviewexplorer.app.features.settings.tv.components.TvSettingsSectionTitle
import com.moviewexplorer.app.features.settings.tv.components.theme.TvThemeSelector

@Composable
fun TvSettingsScreen(
    onBackPress: () -> Unit,
    selectedTheme: AppThemeMode,
    onThemeChange: (AppThemeMode) -> Unit
) {

    val listState = rememberLazyListState()

    val dimens = LocalTvDimens.current

    val elevated by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0 ||
                    listState.firstVisibleItemScrollOffset > 0
        }
    }

    val focusState = remember {
        TvSettingsFocusState()
    }

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
            .onKeyEvent { event ->

                if (event.type != KeyEventType.KeyDown) {
                    return@onKeyEvent false
                }

                when (event.key) {

                    Key.DirectionDown -> {
                        listState.dispatchRawDelta(120f)
                        true
                    }

                    Key.DirectionUp -> {
                        listState.dispatchRawDelta(-120f)
                        true
                    }

                    else -> false
                }
            },
        contentPadding = PaddingValues(
            start = dimens.screenPadding,
            end = dimens.screenPadding
        )
    ) {

        stickyHeader {

            TvDetailsTopBar(
                onBackPress = onBackPress,
                title = "Settings",
                elevated = false,

                focusRequester = focusState.back,

                downRequester = focusState.systemTheme
            )
        }

        item {

            TvSettingsSectionTitle(
                title = "Appearance"
            )
        }

        item {

            SpaceVertical(
                dimens.itemSpacing
            )
        }

        item {

            TvThemeSelector(
                selectedTheme = selectedTheme,

                systemRequester = focusState.systemTheme,
                lightRequester = focusState.lightTheme,
                darkRequester = focusState.darkTheme,

                upRequester = focusState.back,

                downRequester = focusState.defaultContent,

                onThemeChange = onThemeChange
            )
        }

        item {

            SpaceVertical(
                dimens.sectionSpacing
            )
        }

        item {
            SpaceVertical(40.dp)
        }

        item {
            TvSettingsSectionTitle(
                title = "Preferences"
            )
        }

        item {
            SpaceVertical(12.dp)
        }

        item {
            TvSettingsItem(
                title = "Default Content",
                trailingText = "Movies"
            )
        }

        item {
            TvSettingsItem(
                title = "Clear Search History"
            )
        }

        item {
            SpaceVertical(40.dp)
        }

        item {
            TvSettingsSectionTitle(
                title = "Storage"
            )
        }

        item {
            SpaceVertical(12.dp)
        }

        item {
            TvSettingsItem(
                title = "Clear Image Cache"
            )
        }

        item {
            SpaceVertical(40.dp)
        }

        item {
            TvSettingsSectionTitle(
                title = "About"
            )
        }

        item {
            SpaceVertical(12.dp)
        }

        item {
            TvSettingsItem(
                title = "About Movie Explorer"
            )
        }

        item {
            TvSettingsItem(
                title = "Open Source Licenses"
            )
        }

        item {
            TvSettingsItem(
                title = "TMDB Attribution"
            )
        }

        item {
            SpaceVertical(30.dp)
        }

        item {
            Text(
                text = "Version 1.0.0",
                color = AppColors.TextSecondary,
                fontFamily = MontserratFontFamily(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(
                    horizontal = 10.dp
                )
            )
        }

        item {
            SpaceVertical(40.dp)
        }
    }
}

