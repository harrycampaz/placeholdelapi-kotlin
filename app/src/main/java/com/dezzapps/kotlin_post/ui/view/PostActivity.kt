package com.dezzapps.kotlin_post.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dezzapps.kotlin_post.R
import com.dezzapps.kotlin_post.model.User
import com.dezzapps.kotlin_post.viewmodel.PostActivityViewModel
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : AppCompatActivity() {

    private val TAG: String = PostActivity::class.java.simpleName


    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        if(intent.hasExtra("user")) {

            user = intent.getSerializableExtra("user") as User
            name.text = user.name
            email.text = user.email
            phone.text = user.phone

        }

        val postActivityViewModel: PostActivityViewModel = ViewModelProviders.of(this).get(PostActivityViewModel::class.java)

        postActivityViewModel.getPost(this, user.id).observeForever(Observer {
            it.forEach {
                Log.d(TAG, it.title)
            }
        })

    }
}