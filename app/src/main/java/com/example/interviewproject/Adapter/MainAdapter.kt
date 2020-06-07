package com.example.interviewproject.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewproject.Adapter.ViewHolder.MainViewHolder
import com.example.interviewproject.Model.Response.GithubResponse
import com.example.interviewproject.Page.ItemClick
import com.example.interviewproject.R

class MainAdapter(private val callback: ItemClick): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var data = GithubResponse()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_user,parent,false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       when(holder){
            is MainViewHolder -> holder.setUserData(data,position,callback)
       }
    }
}