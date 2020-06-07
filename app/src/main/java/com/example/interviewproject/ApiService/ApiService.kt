package com.example.interviewproject.ApiService

import com.example.interviewproject.Model.Response.GithubResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun fetchData(@Query("since") since: String = "0", @Query("per_page")
    page: String = "100"): Single<Response<GithubResponse>>

}