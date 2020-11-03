package com.example.interviewproject.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.interviewproject.model.repository.DataRepository
import com.example.interviewproject.model.response.UserResponse
import com.example.interviewproject.utils.addComp
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

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