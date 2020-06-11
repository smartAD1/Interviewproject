package com.example.interviewproject.utils

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


    fun Disposable.addComp(compositeDisposable : CompositeDisposable) {
        compositeDisposable.add(this)
    }