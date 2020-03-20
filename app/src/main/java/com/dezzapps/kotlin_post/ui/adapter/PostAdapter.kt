package com.dezzapps.kotlin_post.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dezzapps.kotlin_post.R
import com.dezzapps.kotlin_post.model.Post
import com.dezzapps.kotlin_post.ui.holder.PostViewHolder

class PostAdapter(val  postList: List<Post>, val context: Context) : RecyclerView.Adapter<PostViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.post_list_item, parent, false)

        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {

        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        holder.bind(postList[position], context)

    }
}