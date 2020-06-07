package com.example.interviewproject.ApiService

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users/")
    fun fetchData(@Query("since") since: String, @Query("per_page")
    page: String): Single<Response<String>>

}