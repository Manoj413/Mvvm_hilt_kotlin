package com.example.apimultiplecall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apimultiplecall.Models.ResultInfo
import com.example.apimultiplecall.Models.Results
import com.example.apimultiplecall.Repository.ResultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(private val repository:ResultRepository):ViewModel() {
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val resultLiveData: LiveData<ResultInfo>
        get() = repository.character
    val resultLoadError = MutableLiveData<String?>()

    init {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            repository.getCharacters()
        }
    }


    private fun onError(message: String) {
        resultLoadError.value = message
    }
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}