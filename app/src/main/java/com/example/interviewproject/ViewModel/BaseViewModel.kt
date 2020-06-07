package com.example.interviewproject.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.interviewproject.Model.Response.GithubResponse
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel :ViewModel() {
    val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}