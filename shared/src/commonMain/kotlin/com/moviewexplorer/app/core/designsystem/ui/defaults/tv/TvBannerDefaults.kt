package com.moviewexplorer.app.core.designsystem.ui.defaults.tv

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType

@Immutable
object TvBannerDefaults {

//    fun height(windowType: TvWindowType): Dp =
//        when (windowType) {
//            TvWindowType.Compact -> 600.dp
//            TvWindowType.Medium -> 700.dp
//            TvWindowType.Expanded -> 800.dp
//        }

    fun height(windowType: TvWindowType): Dp =
//        when(windowType) {
//            TvWindowType.Compact -> 300.dp
//            TvWindowType.Medium -> 340.dp
//            TvWindowType.Expanded -> 380.dp
//        }
        when (windowType) {
            TvWindowType.Compact -> 360.dp
            TvWindowType.Medium -> 420.dp
            TvWindowType.Expanded -> 480.dp
        }


    fun contentWidth(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 520.dp
            TvWindowType.Medium -> 650.dp
            TvWindowType.Expanded -> 780.dp
        }

    fun watchButtonWidth(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 200.dp
            TvWindowType.Medium -> 220.dp
            TvWindowType.Expanded -> 240.dp
        }

    fun detailsButtonWidth(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 180.dp
            TvWindowType.Medium -> 200.dp
            TvWindowType.Expanded -> 220.dp
        }

    fun detailsBannerHeight(windowType: TvWindowType): Dp =
//        when (windowType) {
//            TvWindowType.Compact -> 720.dp
//            TvWindowType.Medium -> 820.dp
//            TvWindowType.Expanded -> 920.dp
//        }
//        when(windowType) {
//            TvWindowType.Compact -> 300.dp
//            TvWindowType.Medium -> 340.dp
//            TvWindowType.Expanded -> 380.dp
//        }
        when (windowType) {
            TvWindowType.Compact -> 400.dp
            TvWindowType.Medium -> 450.dp
            TvWindowType.Expanded -> 500.dp
        }

    fun detailsContentWidth(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 720.dp
            TvWindowType.Medium -> 860.dp
            TvWindowType.Expanded -> 1000.dp
        }

    fun detailsOverviewHeight(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 80.dp
            TvWindowType.Medium -> 90.dp
            TvWindowType.Expanded -> 100.dp
        }

    fun detailsButtonHeight(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 56.dp
            TvWindowType.Medium -> 60.dp
            TvWindowType.Expanded -> 64.dp
        }
}