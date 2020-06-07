package com.example.interviewproject.Page

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interviewproject.Adapter.MainAdapter
import com.example.interviewproject.Model.Response.GithubResponseItem
import com.example.interviewproject.R
import com.example.interviewproject.ViewModel.MainViewModel
import com.example.interviewproject.ViewModelFactory.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_main.*

interface ItemClick {
    fun getCallBack(data: GithubResponseItem)
}

class MainFragment : Fragment(),ItemClick {


    private var viewModel: MainViewModel? = null
    private val adapter: MainAdapter by lazy {
        MainAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = activity?.run {
            ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        context?.let {
            userListView.layoutManager = LinearLayoutManager(it)
            userListView.adapter = adapter
        }
        bindViewModel()
    }

    private fun bindViewModel() {
        viewModel?.run {
            githubData.observe(viewLifecycleOwner, Observer {
                adapter.data = it
                adapter.notifyDataSetChanged()
            })
            errorMessage.observe(viewLifecycleOwner, Observer {

            })
        }
    }

    override fun getCallBack(data: GithubResponseItem) {
        TODO("Not yet implemented")
    }
}