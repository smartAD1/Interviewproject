package com.example.interviewproject.Page

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.interviewproject.R
import com.example.interviewproject.ViewModel.MainViewModel
import com.example.interviewproject.ViewModelFactory.MainViewModelFactory

class MainFragment : Fragment() {


    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = activity?.run {
            ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        viewModel?.run {
            githubData.observe(viewLifecycleOwner, Observer {
                Log.d("myViewData","$it")
            })
            errorMessage.observe(viewLifecycleOwner, Observer {
                Log.d("myViewData","$it")
            })
        }
    }

    companion object {
        var mainFragment: MainFragment? = MainFragment()
        @JvmStatic
        fun newInstance():MainFragment {
            if (mainFragment == null) {
                mainFragment =  MainFragment()
            }

            return mainFragment as MainFragment
        }
    }
}