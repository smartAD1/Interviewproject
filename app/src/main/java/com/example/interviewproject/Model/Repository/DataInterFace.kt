package com.example.interviewproject.Model.Repository

import com.example.interviewproject.Model.Response.GithubResponse
import io.reactivex.Single
import retrofit2.Response

interface DataInterFace {

    fun fetchData(): Single<Response<GithubResponse>>
}