package com.example.interviewproject.Model.Repository

import com.example.interviewproject.Model.Response.GithubResponse
import com.example.interviewproject.Model.Response.UserResponse
import io.reactivex.Single
import retrofit2.Response

interface DataInterFace {

    fun fetchData(): Single<Response<GithubResponse>>

    fun fetchUserData(id: String): Single<Response<UserResponse>>
}