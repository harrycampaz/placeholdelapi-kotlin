package com.dezzapps.kotlin_post.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dezzapps.kotlin_post.model.User
import com.dezzapps.kotlin_post.source.UserRepository

class MainActivityViewModel: ViewModel() {

    private val userRepository: UserRepository = UserRepository()

    fun getAllUser(context: Context) {
        userRepository.getLiveData(context)
    }

}