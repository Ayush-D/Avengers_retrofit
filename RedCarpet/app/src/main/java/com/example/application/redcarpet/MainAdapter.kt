package com.example.application.redcarpet

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainAdapter(val userList : MainActivity.HomeFeed): RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {  //() this means constructor of this class


    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        holder?.bind(userList.videos[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder = CustomViewHolder(LayoutInflater.
    from(parent?.context).inflate(R.layout.video_row,parent,false))

    override fun getItemCount(): Int {
        return userList.videos.size
    }

    class CustomViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){

        fun bind(userList: MainActivity.Video){
           // itemView?.imageView?. = userList.name
           // itemView?.textView?.textView = userList.address.toString()
        }
    }

}