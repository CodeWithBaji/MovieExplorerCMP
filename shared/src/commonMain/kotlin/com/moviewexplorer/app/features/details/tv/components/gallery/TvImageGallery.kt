package com.moviewexplorer.app.features.details.tv.components.gallery



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.domain.model.Banner


@Composable
fun TvImageGallery(
    banners: List<Banner>,
    firstItemRequester: FocusRequester,
    onUp: () -> Unit
) {

    val dimens = LocalTvDimens.current
    val montserrat = MontserratFontFamily()

    if (banners.isEmpty()) return

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(24.dp)
                    .clip(RoundedCornerShape(50))
                    .background(AppColors.Primary)
            )

            SpacerHorizontal(dimens.itemSpacing)


            Text(
                text = "Image Gallery",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = montserrat,
                    fontSize = dimens.sectionTitleFont,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.TextPrimary
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        SpaceVertical(
            dimens.itemSpacing
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            itemsIndexed(
                items = banners,
                key = { index, banner ->
                    banner.filePath ?: index
                }
            ) { index, banner ->

                TvGalleryItem(
                    banner = banner,

                    modifier = Modifier
                        .then(
                            if (index == 0) {
                                Modifier.focusRequester(
                                    firstItemRequester
                                )
                            } else {
                                Modifier
                            }
                        )
                        .onKeyEvent { event ->

                            if (
                                event.type != KeyEventType.KeyDown
                            ) {
                                return@onKeyEvent false
                            }

                            when (event.key) {

                                Key.DirectionUp -> {
                                    onUp()
                                    true
                                }

                                else -> false
                            }
                        }
                )
            }
        }
    }
}