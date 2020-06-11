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
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.interviewproject.R
import com.example.interviewproject.viewModel.UserContentViewModel
import com.example.interviewproject.viewModelFactory.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_user_content.*

class UserContentFragment : Fragment() {

    private var id = ""
    private val viewModel: UserContentViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory()).get(UserContentViewModel::class.java)
    }
    private val navController: NavController by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_user_content, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            id = it.getString("id") ?: ""
        }
        viewModel.fetchUserData(id)
        viewModel.run {
            userData.observe(viewLifecycleOwner, Observer {
                Log.d("myViewData","$it")
                context?.let {contexts->
                    Glide.with(contexts).load(it.avatarUrl).apply(RequestOptions.circleCropTransform()).into(userPicture)
                    isUserName.text = it.name
                    bio.text = it.bio
                    locationStr.text = it.location
                    linkStr.text = it.blog
                    avatarName.text = it.login
                    site.text = it.type
                    userpage.visibility = View.VISIBLE
                }
            })
            errorMessage.observe(viewLifecycleOwner, Observer {
                Log.d("errorData","$it")
            })
        }

        close.setOnClickListener {
            navController.navigate(R.id.action_userContentFragment_to_mainFragment2)
        }
    }

}