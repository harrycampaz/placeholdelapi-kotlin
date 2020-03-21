package com.dezzapps.kotlin_post.ui.adapter

import android.widget.Filter
import com.dezzapps.kotlin_post.model.User
import java.util.*

class CustomFilter(val filterUser: List<User>, val userAdapter: UserAdapter): Filter() {
    override fun performFiltering(p0: CharSequence?): FilterResults {

        val results = FilterResults()
        var charSequence = p0

        //CHECK CONSTRAINT VALIDITY
        //CHECK CONSTRAINT VALIDITY
        if (charSequence != null && charSequence.length > 0) { //CHANGE TO UPPER
            charSequence = charSequence.toString().toUpperCase()
            //STORE OUR FILTERED PLAYERS
            val filteredUsers: MutableList<User> = ArrayList()
            for (i in filterUser.indices) { //CHECK
                if (filterUser[i].name.toUpperCase().contains(charSequence)) { //ADD PLAYER TO FILTERED PLAYERS
                    filteredUsers.add(filterUser[i])
                }
            }
            results.count = filteredUsers.size
            results.values = filteredUsers
        } else {
            results.count = filterUser.size
            results.values = filterUser
        }

        return results
    }

    override fun publishResults(p0: CharSequence?, filterResults: FilterResults?) {

        if (filterResults != null) {
            userAdapter.userList = filterResults.values as List<User>
        }

        userAdapter.notifyDataSetChanged()
    }
}