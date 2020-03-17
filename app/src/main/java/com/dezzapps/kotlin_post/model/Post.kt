package com.dezzapps.kotlin_post.model


import com.google.gson.annotations.SerializedName

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)