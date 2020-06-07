package com.example.interviewproject.Model.Repository

import io.reactivex.Single
import retrofit2.Response

class GithubModel :DataInterFace{
    override fun fetchData(): Single<Response<String>> {
        TODO("Not yet implemented")
    }
}