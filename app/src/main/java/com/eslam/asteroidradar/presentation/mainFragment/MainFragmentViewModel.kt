package com.eslam.asteroidradar.presentation.mainFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eslam.asteroidradar.domain.repository.AsteroidsRepository
import com.eslam.asteroidradar.domain.repository.ImageOfDayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val asteroidsRepository: AsteroidsRepository,
    private val imageOfDayRepository: ImageOfDayRepository
) : ViewModel() {

    var asteroidsList = asteroidsRepository.getAsteroids()
    var imageOfDay = imageOfDayRepository.getImageOfDay()

    val asteroidErrorMessage = asteroidsRepository.getErrorMessage()
    val imageErrorMessage = asteroidsRepository.getErrorMessage()

    init {
        viewModelScope.launch {
            asteroidsRepository.refreshAsteroids()
            imageOfDayRepository.refreshImageOfDay()
        }
        asteroidsList = asteroidsRepository.getAsteroids()
    }

}