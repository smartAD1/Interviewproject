package com.example.interviewproject.utils

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable


fun Disposable.addComp(compositeDisposable : CompositeDisposable) {
        compositeDisposable.add(this)
    }