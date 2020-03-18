package com.dezzapps.kotlin_post.source.services

import com.dezzapps.kotlin_post.model.Post
import com.dezzapps.kotlin_post.model.User
import com.dezzapps.kotlin_post.rest.Endpoints.Companion.GET_POST_USER
import com.dezzapps.kotlin_post.rest.Endpoints.Companion.GET_USERS
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface DataServices {

    @GET(GET_USERS)
    fun getUsers(): Call<List<User>>

    @GET(GET_POST_USER)
    fun getPosts(@QueryMap params: Map<String, Int> ): Call<List<Post>>

}