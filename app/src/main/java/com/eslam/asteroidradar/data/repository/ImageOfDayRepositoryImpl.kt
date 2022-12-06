package com.eslam.asteroidradar.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eslam.asteroidradar.data.network.NetworkServices
import com.eslam.asteroidradar.data.presistentStorage.room.ImageOfDayDao
import com.eslam.asteroidradar.domain.repository.ImageOfDayRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ImageOfDayRepositoryImpl @Inject constructor(
    private val networkServices: NetworkServices,
    private val roomDao: ImageOfDayDao
) : ImageOfDayRepository {

    override fun getImageOfDay() = roomDao.getImageOfTheDay()

    val errorMessage = MutableLiveData<String>()


    override suspend fun refreshImageOfDay() {
        withContext(Dispatchers.IO) {

            try {
                val response = networkServices.getImageOfDay()
                if (response.isSuccessful && response.body() != null) {
                    roomDao.addImageOfTheDay(response.body()!!)
                } else {
                    errorMessage.postValue(response.message())
                }
            } catch (e: java.lang.Exception) {
                errorMessage.postValue("No internet connection")
                Log.d("TAG", e.printStackTrace().toString())
            }
        }
    }

    override fun getErrorMessage(): LiveData<String> {
        return errorMessage
    }

}