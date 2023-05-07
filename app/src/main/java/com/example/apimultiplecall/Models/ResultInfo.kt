package com.example.apimultiplecall.Models

import com.google.gson.annotations.SerializedName

data class ResultInfo (
    @SerializedName("results")
    var results: List<Results>? = null
)