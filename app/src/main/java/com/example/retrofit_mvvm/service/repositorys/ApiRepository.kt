package com.example.retrofit_mvvm.service.repositorys

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.retrofit_mvvm.service.api.ApiModel
import com.example.retrofit_mvvm.service.api.RetrofitBuilder
import kotlinx.coroutines.launch

class ApiRepository {
    suspend fun getPost(): ApiModel = RetrofitBuilder.api.getAllPost()
}