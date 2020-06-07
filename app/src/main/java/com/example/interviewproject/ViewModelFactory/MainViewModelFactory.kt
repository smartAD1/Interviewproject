package com.example.interviewproject.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.interviewproject.Model.Repository.DataRepository
import com.example.interviewproject.ViewModel.MainViewModel

class MainViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(MainViewModel::class.java) -> MainViewModel(
                    dataRepository = DataRepository()
                )
                else -> throw IllegalArgumentException(
                    "Unknown ViewModel class: ${modelClass.name}")
            }

        }as T


}