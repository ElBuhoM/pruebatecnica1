package com.admc.pruebatecnica.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admc.pruebatecnica.data.ApodRepository
import com.admc.pruebatecnica.data.model.Apod
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.security.auth.callback.Callback

@HiltViewModel
class ApodViewModel @Inject constructor(private val apodRepository: ApodRepository) : ViewModel() {
    private val _apodData = MutableLiveData<Apod>()
    val apodData: LiveData<Apod> get() = _apodData

    fun getRandomApod(apiKey: String) {
        viewModelScope.launch {
            val response = apodRepository.getApodData(null, null, null, 1, false, apiKey)
            if (response.isSuccessful) {
                val apodList = response.body()
                if (apodList != null) {
                    val randomIndex = (0 until apodList.size).random()
                    val randomApod = apodList[randomIndex]
                    _apodData.postValue(randomApod)
                }
            } else {

            }
        }
    }
}
