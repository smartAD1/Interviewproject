package com.example.interviewproject.Utils

import com.example.interviewproject.ApiService.ApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {
    fun getRetrofit(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://opendata.cwb.gov.tw/api/v1/rest/datastore/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)
    }


}