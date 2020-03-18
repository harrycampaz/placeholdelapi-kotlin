package com.dezzapps.kotlin_post.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dezzapps.kotlin_post.R
import com.dezzapps.kotlin_post.model.User
import com.dezzapps.kotlin_post.ui.adapter.UserAdapter
import com.dezzapps.kotlin_post.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG: String = MainActivity::class.java.simpleName
    lateinit var userAdapter: UserAdapter
    lateinit var userList: List<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainActivityViewModel: MainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        userList = ArrayList()
        mainActivityViewModel.getAllUser(this).observeForever(Observer{
           if(it != null){
               userList = it
               showRecyclerView()
           }
        })

    }

    fun showRecyclerView(){
        recyclerViewSearchResults.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(userList, this)
        recyclerViewSearchResults.adapter = userAdapter
        userAdapter.notifyDataSetChanged()
    }
}
