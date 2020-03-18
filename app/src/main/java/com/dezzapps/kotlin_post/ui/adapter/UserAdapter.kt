package com.dezzapps.kotlin_post.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dezzapps.kotlin_post.R
import com.dezzapps.kotlin_post.model.User
import com.dezzapps.kotlin_post.ui.holder.UserViewHolder

class UserAdapter(val userList: List<User>, val context: Context): RecyclerView.Adapter<UserViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item, parent, false)

        return UserViewHolder(view)

    }

    override fun getItemCount(): Int {

        return userList.size

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position], context)
    }
}