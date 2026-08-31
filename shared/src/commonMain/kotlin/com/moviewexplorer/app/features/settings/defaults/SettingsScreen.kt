package com.moviewexplorer.app.features.settings.defaults

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.features.details.defaults.components.topBar.DetailsTopBar
import com.moviewexplorer.app.features.settings.defaults.components.SettingsItem
import com.moviewexplorer.app.features.settings.defaults.components.SettingsSectionTitle
import com.moviewexplorer.app.features.settings.defaults.components.theme.AppThemeMode
import com.moviewexplorer.app.features.settings.defaults.components.theme.ThemeSelector

@Composable
fun SettingsScreen(
    onBackPress: () -> Unit,
    selectedTheme: AppThemeMode,
    onThemeChange: (AppThemeMode) -> Unit
) {

    val dimens = LocalAppDimens.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
    ) {

        stickyHeader {
            DetailsTopBar(
                elevated = true,
                title = "Settings",
                onBackPress = onBackPress
            )
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = dimens.screenPadding,
                        vertical = dimens.sectionSpacing
                    )
            ) {

                SettingsSectionTitle("Appearance")

                SpaceVertical(dimens.itemSpacing)

                // Theme selector
                ThemeSelector(
                    selectedTheme = selectedTheme,
                    onThemeChange = onThemeChange
                )

                SpaceVertical(dimens.sectionSpacing)

                SettingsSectionTitle("Preferences")

                SpaceVertical(dimens.itemSpacing)

                SettingsItem(
                    title = "Default Content",
                    value = "Movies",
                    onClick = {
                        // Open default content selection
                    }
                )

                SettingsItem(
                    title = "Clear Search History",
                    onClick = {
                        // Clear search history
                    }
                )

                SpaceVertical(dimens.sectionSpacing)

                SettingsSectionTitle("Storage")

                SpaceVertical(dimens.itemSpacing)

                SettingsItem(
                    title = "Clear Image Cache",
                    onClick = {
                        // Clear cache
                    }
                )

                SpaceVertical(dimens.sectionSpacing)

                SettingsSectionTitle("About")

                SpaceVertical(dimens.itemSpacing)

                SettingsItem(
                    title = "About Movie Explorer",
                    onClick = {
                        // Navigate to About
                    }
                )

                SettingsItem(
                    title = "Open Source Licenses",
                    onClick = {
                        // Navigate to licenses
                    }
                )

                SettingsItem(
                    title = "TMDB Attribution",
                    onClick = {
                        // Open TMDB attribution
                    }
                )

                SpaceVertical(dimens.sectionSpacing)

                Text(
                    text = "Version 1.0.0",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontFamily = MontserratFontFamily(),
                        fontSize = dimens.captionFont,
                        color = AppColors.TextSecondary
                    )
                )

                SpaceVertical(dimens.sectionSpacing)
            }
        }
    }
}