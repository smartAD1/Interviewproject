package com.example.interviewproject.Model.Repository

import com.example.interviewproject.Model.Response.GithubResponse
import com.example.interviewproject.Model.Response.UserResponse
import com.example.interviewproject.Utils.RetrofitManager
import io.reactivex.Single
import retrofit2.Response

class DataRepository: DataInterFace {
    override fun fetchData(): Single<Response<GithubResponse>> =
        RetrofitManager.getRetrofit().fetchData()

    override fun fetchUserData(id: String): Single<Response<UserResponse>> =
        RetrofitManager.getRetrofit().fetchUserData(id)
}