package com.dezzapps.kotlin_post.source.services

import com.dezzapps.kotlin_post.model.User
import com.dezzapps.kotlin_post.rest.Endpoints.Companion.GET_POST_USER
import com.dezzapps.kotlin_post.rest.Endpoints.Companion.GET_USERS
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DataServices {

    @GET(GET_USERS)
    fun getUsers(): Call<List<User>>

    @GET("$GET_POST_USER/{user_id}")
    fun getPosts(@Path("user_id") id: Int)


}