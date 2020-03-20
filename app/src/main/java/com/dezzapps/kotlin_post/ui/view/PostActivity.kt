package com.dezzapps.kotlin_post.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dezzapps.kotlin_post.R
import com.dezzapps.kotlin_post.model.Post
import com.dezzapps.kotlin_post.model.User
import com.dezzapps.kotlin_post.ui.adapter.PostAdapter
import com.dezzapps.kotlin_post.viewmodel.PostActivityViewModel
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : AppCompatActivity() {

    private val TAG: String = PostActivity::class.java.simpleName


    lateinit var postAdapter: PostAdapter
    lateinit var postsList: List<Post>
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        val postActivityViewModel: PostActivityViewModel = ViewModelProviders.of(this).get(PostActivityViewModel::class.java)

        if(intent.hasExtra("user")) {

            user = intent.getSerializableExtra("user") as User
            name.text = user.name
            email.text = user.email
            phone.text = user.phone

        }

        postActivityViewModel.getPost(this, user.id).observeForever(Observer {

            if(it != null){
                postsList = it
                showRecyclerView()
            }

        })

    }

    fun showRecyclerView(){
        recyclerViewPostsResults.layoutManager = LinearLayoutManager(this)
        postAdapter = PostAdapter(postsList, this)
        recyclerViewPostsResults.adapter = postAdapter
        postAdapter.notifyDataSetChanged()

    }
}