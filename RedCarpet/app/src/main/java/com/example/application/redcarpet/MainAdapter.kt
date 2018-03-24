package com.example.application.redcarpet

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(val userList : MainActivity.HomeFeed): RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {  //() this means constructor of this class


    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        holder?.bind(userList.videos[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder = CustomViewHolder(LayoutInflater.
    from(parent?.context).inflate(R.layout.video_row,parent,false))

    override fun getItemCount(): Int {
        return userList.videos.count()
    }

    class CustomViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){

        fun bind(userList: MainActivity.Video){
            //itemView?.imageView?.= userList.name
            itemView?.textView?.text= userList.name
            itemView?.textView3_channelName?.text=userList.channel.name
            //for thumbnailImage
            val thumbnailImageView = itemView?.imageView_video_thumbnail
            Picasso.get().load(userList.imageUrl).into(thumbnailImageView)
            //for ChannelImage
            val channelImage = itemView?.imageView3
            Picasso.get().load(userList.channel.profileImageUrl).into(channelImage)
        }
    }

}