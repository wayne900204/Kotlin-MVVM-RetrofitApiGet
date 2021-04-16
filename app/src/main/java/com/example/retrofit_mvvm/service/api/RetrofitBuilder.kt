package com.example.retrofit_mvvm.service.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object {
        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("https://virtserver.swaggerhub.com/moontai0724/cmrdb-6th-hackathon/0.1.0/restaurants/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: Api by lazy {
            retrofit.create(Api::class.java)
        }
    }
}