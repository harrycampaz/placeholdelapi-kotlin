package com.dezzapps.kotlin_post.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dezzapps.kotlin_post.model.Post
import com.dezzapps.kotlin_post.source.PostsRepository

class PostActivityViewModel: ViewModel() {

    private val postsrepository: PostsRepository = PostsRepository()

    fun  getPost(context: Context, userId: Int): LiveData<List<Post>>{
        return postsrepository.getLiveData(context, userId)
    }

}