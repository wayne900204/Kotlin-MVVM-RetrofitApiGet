package com.example.retrofit_mvvm.service.api

data class ApiModel (
    val success: Boolean,
    val message: String,
    val data: List<Datum>
)

data class Datum (
    val id: Long,
    val name: String,
    val description: String,
    val phone: String,
    val address: String,
    val lowestPrice: Long
)
