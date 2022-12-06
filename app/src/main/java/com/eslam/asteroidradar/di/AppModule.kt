package com.eslam.asteroidradar.di

import android.content.Context
import androidx.room.Room
import com.eslam.asteroidradar.data.presistentStorage.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApplicationDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, AppDatabase::class.java, "nasa_asteroids")
            .allowMainThreadQueries().build()

    @Provides
    @Singleton
    fun provideAsteroidsDao(db: AppDatabase) = db.asteroidsDao()

    @Provides
    @Singleton
    fun provideImageOfDayDao(db: AppDatabase) = db.imageOfTheDayDao()

}