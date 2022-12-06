package com.eslam.asteroidradar.di

import com.eslam.asteroidradar.data.repository.AsteroidsRepositoryImpl
import com.eslam.asteroidradar.data.repository.ImageOfDayRepositoryImpl
import com.eslam.asteroidradar.domain.repository.AsteroidsRepository
import com.eslam.asteroidradar.domain.repository.ImageOfDayRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideAsteroidsRepository(asteroidsRepositoryImpl: AsteroidsRepositoryImpl): AsteroidsRepository

    @Binds
    abstract fun provideImageOfDayRepository(asteroidsRepositoryImpl: ImageOfDayRepositoryImpl): ImageOfDayRepository


}