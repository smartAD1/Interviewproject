package com.example.interviewproject.model.repository

import com.example.interviewproject.model.response.GithubResponse
import com.example.interviewproject.model.response.UserResponse
import io.reactivex.Single
import retrofit2.Response

interface DataInterFace {

    fun fetchData(): Single<Response<GithubResponse>>

    fun fetchUserData(id: String): Single<Response<UserResponse>>
}