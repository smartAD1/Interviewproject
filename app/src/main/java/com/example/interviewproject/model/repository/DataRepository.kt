package com.example.interviewproject.model.repository

import com.example.interviewproject.model.response.GithubResponse
import com.example.interviewproject.model.response.UserResponse
import com.example.interviewproject.utils.RetrofitManager
import io.reactivex.Single
import retrofit2.Response

class DataRepository: DataInterFace {
    override fun fetchData(): Single<Response<GithubResponse>> =
        RetrofitManager.getRetrofit().fetchData()

    override fun fetchUserData(id: String): Single<Response<UserResponse>> =
        RetrofitManager.getRetrofit().fetchUserData(id)
}