package com.example.interviewproject.apiService

import com.example.interviewproject.model.response.GithubResponse
import com.example.interviewproject.model.response.UserResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun fetchData(@Query("since") since: String = "0", @Query("per_page")
    page: String = "100"): Single<Response<GithubResponse>>

    @GET("users/{userID}")
    fun fetchUserData(@Path("userID") id: String): Single<Response<UserResponse>>
}