package com.dezzapps.kotlin_post.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.dezzapps.kotlin_post.R
import com.dezzapps.kotlin_post.model.User
import com.dezzapps.kotlin_post.ui.holder.UserViewHolder

class UserAdapter(var userList: List<User>, val context: Context): RecyclerView.Adapter<UserViewHolder>(), Filterable{

    var filter: CustomFilter? = null
    var filterList: List<User> = userList

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

    override fun getFilter(): Filter {

        if (filter == null) {
            filter = CustomFilter(filterList, this)
        }

        return filter as CustomFilter
    }
}