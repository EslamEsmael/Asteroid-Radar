package com.eslam.asteroidradar.domain.repository

import androidx.lifecycle.LiveData
import com.eslam.asteroidradar.data.model.ImageOfDay

interface ImageOfDayRepository {

    fun getImageOfDay(): LiveData<ImageOfDay>

    suspend fun refreshImageOfDay()

    fun getErrorMessage(): LiveData<String>
}