package com.eslam.asteroidradar.domain.repository

import androidx.lifecycle.LiveData
import com.eslam.asteroidradar.data.model.Asteroid

interface AsteroidsRepository {


    fun getAsteroids(): LiveData<List<Asteroid>>

    suspend fun refreshAsteroids()

    fun deleteOlderThanToday()

    fun getErrorMessage(): LiveData<String>
}