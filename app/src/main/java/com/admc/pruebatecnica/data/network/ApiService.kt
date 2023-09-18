package com.admc.pruebatecnica.data.network

import com.admc.pruebatecnica.data.model.Apod
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
@GET("planetary/apod")
suspend fun getImgeDay(
    @Query("date") date:String?,
    @Query("start_date") startDate:String?,
    @Query("end_date") endDate:String?,
    @Query("count") count:Int?,
    @Query("thumbs") thumbs:Boolean,
    @Query("api_key") apiKey:String
): Response<List<Apod>>
}