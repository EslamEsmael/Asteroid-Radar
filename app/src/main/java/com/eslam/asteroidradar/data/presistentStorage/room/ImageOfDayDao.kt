package com.eslam.asteroidradar.data.presistentStorage.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.eslam.asteroidradar.data.model.ImageOfDay

@Dao
interface ImageOfDayDao {

    @Query("SELECT * FROM ImageOfDay pod ORDER BY date DESC LIMIT 0,1")
    fun getImageOfTheDay(): LiveData<ImageOfDay>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImageOfTheDay(asteroid: ImageOfDay)

    @Delete
    fun removeImageOfTheDay(asteroid: ImageOfDay)

    @Update
    fun updateImageOfTheDay(asteroid: ImageOfDay)


}