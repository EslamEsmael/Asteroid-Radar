package com.eslam.asteroidradar.domain

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.eslam.asteroidradar.domain.repository.AsteroidsRepository
import com.eslam.asteroidradar.domain.repository.ImageOfDayRepository
import retrofit2.HttpException
import javax.inject.Inject

class RefreshWorker @Inject constructor(
    private val asteroidsRepository: AsteroidsRepository,
    private val imageOfDayRepository: ImageOfDayRepository,
    appContext: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(
    appContext, workerParameters
) {

    companion object {
        const val WORKER_NAME = "Refresh_worker"
    }

    override suspend fun doWork(): Result {
        asteroidsRepository.deleteOlderThanToday()
        return try {
            imageOfDayRepository.refreshImageOfDay()
            asteroidsRepository.refreshAsteroids()

            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }
}