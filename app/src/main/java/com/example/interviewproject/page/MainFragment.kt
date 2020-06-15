package com.example.interviewproject.page

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interviewproject.adapter.MainAdapter
import com.example.interviewproject.R
import com.example.interviewproject.viewModel.MainViewModel
import com.example.interviewproject.viewModelFactory.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.math.log

interface ItemClick {
    fun getCallBack(login: String)
}

class MainFragment : Fragment(),ItemClick {


    private var viewModel: MainViewModel? = null
    private val navController: NavController by lazy { findNavController() }
    private val adapter: MainAdapter by lazy {
        MainAdapter(this)
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
                Log.d("errorData","$it")
            })
        }
    }

    override fun getCallBack(login: String) {
//        val bundle = Bundle()
//        bundle.putString("id",login)
        val args = MainFragmentDirections.actionMainFragment2ToUserContentFragment(login)
        navController.navigate(R.id.action_mainFragment2_to_userContentFragment)
        navController.navigate(args)
    }
}