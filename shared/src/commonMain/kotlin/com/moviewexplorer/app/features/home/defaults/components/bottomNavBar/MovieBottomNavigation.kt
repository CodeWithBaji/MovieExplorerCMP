package com.moviewexplorer.app.features.home.defaults.components.bottomNavBar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily

@Composable
fun MovieBottomNavigation(
    selectedItem: BottomNavItem,
    onItemSelected: (BottomNavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val montserrat = MontserratFontFamily()

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Watchlist,
        BottomNavItem.Settings
    )

    val inactiveNavColor =
        if (AppColors.Background.luminance() > 0.5f) {
            Color(0xFF5F6368)
        } else {
            AppColors.TextSecondary
        }

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = AppColors.Surface.copy(alpha = 0.95f),
        tonalElevation = 0.dp,
        shadowElevation = 0.dp,
        border = BorderStroke(
            width = 0.5.dp,
            color = Color.White.copy(alpha = 0.10f)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            items.forEach { item ->

                val selected = item == selectedItem

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable {
                            onItemSelected(item)
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier.size(22.dp),
                        tint = if (selected) {
                            AppColors.PrimaryLight
                        } else {
                            inactiveNavColor
                        }
                    )

                    SpaceVertical(3.dp)

                    Text(
                        text = item.title,
                        fontFamily = montserrat,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 11.sp,
                        color = if (selected) {
                            AppColors.PrimaryLight
                        } else {
                            inactiveNavColor
                        },
                        maxLines = 1
                    )
                }
            }
        }
    }
}