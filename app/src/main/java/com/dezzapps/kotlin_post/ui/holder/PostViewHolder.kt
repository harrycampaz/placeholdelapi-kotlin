package com.dezzapps.kotlin_post.ui.holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dezzapps.kotlin_post.model.Post
import kotlinx.android.synthetic.main.post_list_item.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(context: Context, post: Post){

        itemView.title.text = post.title
        itemView.body.text = post.body

    }
}