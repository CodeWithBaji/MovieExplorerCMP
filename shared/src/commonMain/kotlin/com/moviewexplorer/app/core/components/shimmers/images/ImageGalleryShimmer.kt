package com.moviewexplorer.app.core.components.shimmers.images

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.ui.defaults.BackButtonDefaults
import com.moviewexplorer.app.core.designsystem.ui.defaults.GalleryDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType

@Composable
fun ImageGalleryShimmer() {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val shimmerColors = listOf(
        Color(0xFF242424),
        Color(0xFF303030),
        Color(0xFF242424)
    )

    val transition = rememberInfiniteTransition(
        label = "GalleryShimmer"
    )

    val translateAnim by transition.animateFloat(
        initialValue = -1000f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1100,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "GalleryShimmerAnimation"
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(translateAnim, 0f),
        end = Offset(translateAnim + 500f, 500f)
    )

    val columns = GalleryDefaults.columns(windowType)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F0F))
    ) {

        // Sticky Top Bar
        stickyHeader {

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF151515)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimens.toolbarHeight)
                        .padding(horizontal = dimens.screenPadding),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // Back button shimmer
                    Box(
                        modifier = Modifier
                            .size(
                                BackButtonDefaults.circleSize(windowType)
                            )
                            .clip(CircleShape)
                            .background(brush)
                    )

                    SpacerHorizontal(dimens.itemSpacing)

                    // Title shimmer
                    Box(
                        modifier = Modifier
                            .width(130.dp)
                            .height(20.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(brush)
                    )
                }
            }
        }

        item {
            Spacer(
                modifier = Modifier.height(
                    dimens.sectionSpacing
                )
            )
        }

        item {

            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimens.screenPadding)
            ) {

                val itemWidth =
                    (
                            maxWidth -
                                    dimens.cardSpacing * (columns - 1)
                            ) / columns

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    maxItemsInEachRow = columns,
                    horizontalArrangement = Arrangement.spacedBy(
                        dimens.cardSpacing
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        dimens.cardSpacing
                    )
                ) {

                    // More items than normally visible so
                    // the screen doesn't look empty while loading.
                    repeat(columns * 4) {

                        Box(
                            modifier = Modifier
                                .width(itemWidth)
                                .height(
                                    GalleryDefaults.imageHeight(
                                        windowType
                                    )
                                )
                                .clip(
                                    RoundedCornerShape(
                                        dimens.cornerMedium
                                    )
                                )
                                .background(brush)
                        )
                    }
                }
            }
        }

        item {
            Spacer(
                modifier = Modifier.height(
                    dimens.sectionSpacing
                )
            )
        }
    }
}