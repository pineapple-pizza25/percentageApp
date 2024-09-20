package com.example.percentageapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {
    @POST("calculate-percentage")
    fun calculatePercentage(@Body request: PercentageRequest): Call<PercentageResponse>
}