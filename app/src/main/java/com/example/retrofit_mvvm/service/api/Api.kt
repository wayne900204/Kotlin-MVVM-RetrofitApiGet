package com.example.retrofit_mvvm.service.api

import retrofit2.http.GET

interface Api {

    @GET(".")
    suspend fun getAllPost() : ApiModel
}