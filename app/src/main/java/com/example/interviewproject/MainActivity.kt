package com.example.interviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.interviewproject.Model.Response.GithubResponseItem
import com.example.interviewproject.Page.MainFragment
import com.example.interviewproject.ViewModel.MainViewModel
import com.example.interviewproject.ViewModelFactory.MainViewModelFactory



class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchData()
    }
}