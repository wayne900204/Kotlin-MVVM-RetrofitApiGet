package com.example.retrofit_mvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.retrofit_mvvm.service.api.ApiModel
import com.example.retrofit_mvvm.service.repositorys.ApiRepository
import kotlinx.coroutines.launch

class MyViewModel(application: Application) : AndroidViewModel(application) {

    val postApiData: MutableLiveData<ApiModel> = MutableLiveData()
    private val postRepo: ApiRepository

    init {
        postRepo = ApiRepository()
    }

    fun getPost() {
        viewModelScope.launch {
            try {
                val response = postRepo.getPost()
                postApiData.value = response
                Log.d("XXX", "Success"+response)
            } catch (e: Exception) {
                Log.d("XXX", "getmsg- ${e.message}")
            }
        }
    }
}