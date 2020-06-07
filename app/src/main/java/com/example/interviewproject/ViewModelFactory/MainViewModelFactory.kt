package com.example.interviewproject.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.interviewproject.Model.Repository.DataRepository
import com.example.interviewproject.Page.MainFragment
import com.example.interviewproject.ViewModel.MainViewModel
import com.example.interviewproject.ViewModel.UserContentViewModel

class MainViewModelFactory : ViewModelProvider.Factory {


//    companion object {
//        @Volatile private var viewModelFactory: MainViewModelFactory? = null
//        @JvmStatic
//        fun newInstance(): MainViewModelFactory {
//            if (viewModelFactory == null) viewModelFactory =  MainViewModelFactory()
//            return viewModelFactory!!
//        }
//    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(MainViewModel::class.java) -> MainViewModel(
                    dataRepository = DataRepository()
                )
                isAssignableFrom(UserContentViewModel::class.java) -> UserContentViewModel(
                    dataRepository = DataRepository()
                )
                else -> throw IllegalArgumentException(
                    "Unknown ViewModel class: ${modelClass.name}")
            }

        }as T
}