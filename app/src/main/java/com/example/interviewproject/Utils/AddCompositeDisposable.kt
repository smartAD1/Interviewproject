package com.example.interviewproject.Utils

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

object AddCompositeDisposable {

    fun Disposable.addComp(compositeDisposable : CompositeDisposable) {
        compositeDisposable.add(this)
    }
}