package com.example.interviewproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.interviewproject.model.repository.DataRepository
import com.example.interviewproject.model.response.GithubResponse
import com.example.interviewproject.utils.addComp
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


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