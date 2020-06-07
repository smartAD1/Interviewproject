package com.example.interviewproject.Model.Repository

import io.reactivex.Single
import retrofit2.Response

interface DataInterFace {

    fun fetchData(): Single<Response<String>>
}