package com.eslam.asteroidradar.data.presistentStorage.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eslam.asteroidradar.data.model.Asteroid
import com.eslam.asteroidradar.data.model.ImageOfDay

@Database(entities = [Asteroid::class, ImageOfDay::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun asteroidsDao(): AsteroidsDao
    abstract fun imageOfTheDayDao(): ImageOfDayDao
}