package com.eslam.asteroidradar.data.network

import com.eslam.asteroidradar.data.model.ImageOfDay
import com.eslam.asteroidradar.domain.utlis.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkServices {

    @GET("neo/rest/v1/feed")
    suspend fun getAsteroids(@Query("api_key") apiKey: String = Constants.API_KEY): Response<String>

    @GET("planetary/apod")
    suspend fun getImageOfDay(@Query("api_key") apiKey: String = Constants.API_KEY): Response<ImageOfDay>
}

