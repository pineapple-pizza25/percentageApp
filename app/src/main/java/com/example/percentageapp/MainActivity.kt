package com.example.percentageapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = ApiClient.apiService
        val request = PercentageRequest(value = 30.0, total = 200.0) // Example values

        apiService.calculatePercentage(request).enqueue(object : Callback<PercentageResponse> {
            override fun onResponse(call: Call<PercentageResponse>, response: Response<PercentageResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("Response", "Percentage: ${data?.percentage}")
                } else {
                    Log.e("Error", "Response code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<PercentageResponse>, t: Throwable) {
                Log.e("Error", "Failure: ${t.message}")
            }
        })
    }
}