package com.moviewexplorer.app.data.mapper

import com.moviewexplorer.app.data.dto.details.trailer.Result
import com.moviewexplorer.app.domain.model.Video

fun Result.toDomain(): Video {
    return Video(
        key = key?:"",
        name = name?:""
    )
}