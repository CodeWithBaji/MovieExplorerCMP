package com.moviewexplorer.app.features.home.defaults.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.utils.SectionTitleStyle
import com.moviewexplorer.app.domain.model.Movie
import com.moviewexplorer.app.features.details.defaults.components.DetailTitles

@Composable
fun ContentSection(
    title: String,
    movieList: List<Movie>,
    titleSize: TextUnit = LocalAppDimens.current.sectionTitleFont,
    viewAllSize: TextUnit = LocalAppDimens.current.bodyFont,
    onDetailsScreen: (id: Int) -> Unit,
    titleStyle: SectionTitleStyle = SectionTitleStyle.HOME,
    showViewAll: Boolean = true,
    onViewAll: () -> Unit = {},
) {

    val dimens = LocalAppDimens.current

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {


        when (titleStyle) {

            SectionTitleStyle.HOME -> {
                HomeTitles(
                    title = title,
                    onViewAll = onViewAll
                )
            }

            SectionTitleStyle.DETAILS -> {
                DetailTitles(
                    title = title,
                    showViewAll = showViewAll
                )
            }
        }

        SpaceVertical(dimens.sectionSpacing / 2)

        ContentCards(movieList, onDetailsScreen = {
            onDetailsScreen(it)
        })
    }
}