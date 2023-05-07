package com.example.apimultiplecall.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apimultiplecall.Models.ResultInfo
import com.example.apimultiplecall.Models.Results
import com.example.apimultiplecall.Retrofit.ResultApi
import com.example.apimultiplecall.Utils.ResponseApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResultRepository @Inject constructor(private val resultApi: ResultApi){
    private val _character = MutableLiveData<ResultInfo>()
    val character: LiveData<ResultInfo>
        get()= _character



    suspend fun getCharacters(){
        val result = resultApi.getResultApi()
        if (result.isSuccessful){
            val result_body = resultApi.getResultApi().body()
            _character.postValue( result_body)

            if (result_body!=null) {
                ResponseApi.Success(result_body)


            }else{
                ResponseApi.Error("Something went wrong")
            }
        }else{
            ResponseApi.Error("Something went wrong")
        }
    }
}