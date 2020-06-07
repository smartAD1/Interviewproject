package com.example.interviewproject.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.interviewproject.Model.Repository.DataRepository
import com.example.interviewproject.Model.Response.UserResponse
import com.example.interviewproject.Utils.addComp
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserContentViewModel(private val dataRepository: DataRepository) : BaseViewModel() {
    val userData: LiveData<UserResponse> get() = userTmpData
    private var userTmpData = MutableLiveData<UserResponse>()
    val errorMessage: LiveData<String> get() = errorTmp
    private val errorTmp = MutableLiveData<String>()

    fun fetchUserData(id: String) {
        dataRepository.fetchUserData(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.body()?.let {
                    userTmpData.value = it
                }
            }, {
                Log.d("myViewData","${it.message}")
            }).addComp(compositeDisposable)
    }
}