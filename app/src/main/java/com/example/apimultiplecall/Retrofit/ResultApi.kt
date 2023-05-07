package com.example.apimultiplecall.Retrofit

import com.example.apimultiplecall.Models.ResultInfo
import com.example.apimultiplecall.Models.Results
import com.example.apimultiplecall.Utils.ResponseApi
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ResultApi {
    @GET("character")
    suspend fun getResultApi():Response<ResultInfo>
}