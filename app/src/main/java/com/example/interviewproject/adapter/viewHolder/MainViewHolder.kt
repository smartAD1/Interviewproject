package com.example.interviewproject.adapter.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.interviewproject.model.response.GithubResponse
import com.example.interviewproject.page.ItemClick
import kotlinx.android.synthetic.main.item_list_user.view.*

class MainViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun setUserData(data: GithubResponse, position: Int, callback: ItemClick) = itemView.apply {
        userName.text = data[position].login
        Glide.with(this).load(data[position].avatarUrl).apply(RequestOptions.circleCropTransform()).into(userPic)
        userName.visibility = View.VISIBLE
        userPic.visibility = View.VISIBLE
        setOnClickListener {
            callback.getCallBack("${data[position].login}")
        }
    }
}