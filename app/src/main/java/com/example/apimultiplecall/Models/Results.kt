package com.example.apimultiplecall.Models

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("name")
    val name: String,
    @SerializedName("species")
    val species:String,
    @SerializedName("gender")
    val gender:String,
    @SerializedName("image")
    val image:String,
    @SerializedName("location")
    val location:Location

)
