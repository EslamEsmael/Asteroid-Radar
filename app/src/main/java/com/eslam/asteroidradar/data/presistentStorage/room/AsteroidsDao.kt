package com.eslam.asteroidradar.data.presistentStorage.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.eslam.asteroidradar.data.model.Asteroid

@Dao
interface AsteroidsDao {

    @Query("SELECT COUNT(id) FROM Asteroid")
    fun getAsteroidsCount(): LiveData<Int>

    @Query("SELECT * FROM Asteroid")
    fun getAsteroids(): LiveData<List<Asteroid>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAsteroid(asteroid: Asteroid)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(list: ArrayList<Asteroid>)

    @Delete
    fun removeItem(asteroid: Asteroid)

    @Update
    fun updateItem(asteroid: Asteroid)

}