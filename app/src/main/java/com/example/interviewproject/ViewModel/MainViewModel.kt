package com.example.interviewproject.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.interviewproject.Model.Repository.DataRepository
import com.example.interviewproject.Model.Response.GithubResponse
import com.example.interviewproject.Utils.addComp
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val dataRepository: DataRepository) : BaseViewModel() {
    val githubData: LiveData<GithubResponse> get() = githubTmpData
    private val githubTmpData = MutableLiveData<GithubResponse>()
    val errorMessage: LiveData<String> get() = errorTmp
    private val errorTmp = MutableLiveData<String>()

    fun fetchData() {
        dataRepository.fetchData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.body()?.let {
                    githubTmpData.value = it
                }
            }, {
                errorTmp.value = "${it.message}"
            }).addComp(compositeDisposable)
    }
}