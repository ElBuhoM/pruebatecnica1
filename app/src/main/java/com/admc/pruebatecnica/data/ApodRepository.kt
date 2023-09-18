package com.admc.pruebatecnica.data

import com.admc.pruebatecnica.data.network.ApiService
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class ApodRepository @Inject constructor(private val api: ApiService) {
    suspend  fun getApodData(
        date: String?,
        startDate: String?,
        endDate: String?,
        count:Int?,
        thumbs: Boolean,
        apiKey: String
    ) = api.getImgeDay(date,startDate,endDate, count, thumbs,apiKey)
}