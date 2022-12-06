package com.eslam.asteroidradar.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class ImageOfDay(
    var date: String,
    @PrimaryKey
    val url: String,
    @Json(name = "media_type") val mediaType: String,
    val title: String
)

