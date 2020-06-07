package com.example.interviewproject.Adapter.ViewHolder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.interviewproject.Model.Response.GithubResponse
import kotlinx.android.synthetic.main.item_list_user.view.*

class MainViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun setUserData(data: GithubResponse, position: Int) = itemView.apply {
        userName.text = data[position].login
        Glide.with(this).load(data[position].avatarUrl).apply(RequestOptions.circleCropTransform()).into(userPic)
        userName.visibility = View.VISIBLE
        userPic.visibility = View.VISIBLE
    }
}