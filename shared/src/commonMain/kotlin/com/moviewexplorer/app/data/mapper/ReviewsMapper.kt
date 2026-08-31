package com.moviewexplorer.app.data.mapper

import com.moviewexplorer.app.core.utils.toReviewDate
import com.moviewexplorer.app.domain.model.Review
import com.moviewexplorer.app.data.dto.details.reviews.Result
fun Result.toDomain() : Review{
    return Review(
        avatarPath = authorDetails?.avatarPath,
        name = author,
        content = content,
        rating = authorDetails?.rating,
        date = createdAt?.toReviewDate()
    )
}