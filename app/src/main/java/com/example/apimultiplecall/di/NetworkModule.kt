package com.example.apimultiplecall.di

import com.example.apimultiplecall.Retrofit.ResultApi
import com.example.apimultiplecall.Utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
@Singleton
@Provides
fun providesRetrofit():Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
}

@Singleton
@Provides
fun provideResult(retrofit: Retrofit):ResultApi{
return retrofit.create(ResultApi::class.java)
}
}