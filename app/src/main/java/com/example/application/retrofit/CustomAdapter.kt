package com.example.application.retrofit

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row.view.*


class CustomAdapter (val users: ArrayList<Hero>): RecyclerView.Adapter<CustomAdapter.UserViewHolder>(){

    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        holder?.bind(users[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = UserViewHolder(LayoutInflater.from(parent?.
    context).inflate(R.layout.item_row,parent,false))

    override fun getItemCount() = users.size


    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(user:Hero){
            itemView?.tVname?.text = user.name
            itemView?.tVrealname?.text = user.realname
            itemView?.tVteam?.text = user.team
            itemView?.tVimage?.text = user.imageurl
        }
    }

}