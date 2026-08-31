package com.moviewexplorer.app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Banner(
    val aspectRatio: Float?,
    val filePath: String?,
    val height: Int?,
    val width: Int?
)
