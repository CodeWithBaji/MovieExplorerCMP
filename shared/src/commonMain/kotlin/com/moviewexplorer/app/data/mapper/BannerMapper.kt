package com.moviewexplorer.app.data.mapper

import com.moviewexplorer.app.data.dto.details.banner.Backdrop
import com.moviewexplorer.app.data.remote.NetworkConstants.BANNER_PIC_BASE_URL
import com.moviewexplorer.app.domain.model.Banner

fun Backdrop.toDomain() : Banner{
    return Banner(
         aspectRatio = aspectRatio,
        filePath = "$BANNER_PIC_BASE_URL${filePath}",
        height = height,
        width = width
    )
}