package com.eslam.asteroidradar.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eslam.asteroidradar.data.network.NetworkServices
import com.eslam.asteroidradar.data.presistentStorage.room.AsteroidsDao
import com.eslam.asteroidradar.domain.repository.AsteroidsRepository
import com.eslam.asteroidradar.domain.utlis.parseAsteroidsJsonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.joda.time.DateTime
import org.json.JSONObject
import javax.inject.Inject

class AsteroidsRepositoryImpl @Inject constructor(
    private val networkServices: NetworkServices,
    private val roomDao: AsteroidsDao
) : AsteroidsRepository {

    override fun getAsteroids() = roomDao.getAsteroids()

    val errorMessage = MutableLiveData<String>()

    override suspend fun refreshAsteroids() {
        withContext(Dispatchers.IO) {

            try {
                val asteroidsResponse = networkServices.getAsteroids()
                if (asteroidsResponse.isSuccessful && asteroidsResponse.body() != null) {
                    roomDao.addAll(parseAsteroidsJsonResult(JSONObject(asteroidsResponse.body()!!)))
                } else {
                    errorMessage.postValue(asteroidsResponse.message())
                }
            } catch (e: java.lang.Exception) {
                errorMessage.postValue("No internet connection")
                Log.d("TAG", e.printStackTrace().toString())
            }
        }
    }

    override fun deleteOlderThanToday() {
        val listToBeDeleted = getAsteroids().value?.filter {
            DateTime(it.formattedDate).isBeforeNow
        }

        if (listToBeDeleted != null) {
            for (item in listToBeDeleted) {
                roomDao.removeItem(item)
            }
        }
    }

    override fun getErrorMessage(): LiveData<String> {
        return errorMessage
    }

}