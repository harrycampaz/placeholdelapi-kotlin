package com.dezzapps.kotlin_post.ui.holder

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dezzapps.kotlin_post.model.Post
import com.dezzapps.kotlin_post.model.User
import com.dezzapps.kotlin_post.ui.view.PostActivity
import kotlinx.android.synthetic.main.activity_post.view.*
import kotlinx.android.synthetic.main.user_list_item.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(user: User, context: Context){

        itemView.name.text = user.name
        itemView.phone.text = user.phone
        itemView.email.text = user.email
        itemView.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(context, PostActivity::class.java)
            intent.putExtra("user", user)
            context.startActivity(intent)
        })

    }

}