package com.example.interviewproject.utils

import com.example.interviewproject.apiService.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitManager {
    private val okhttplog = HttpLoggingInterceptor()
    private val client = OkHttpClient.Builder()
        .addInterceptor(okhttplog)
        .build()
    fun getRetrofit(): ApiService {
        okhttplog.setLevel(HttpLoggingInterceptor.Level.BODY)

        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)
    }


}