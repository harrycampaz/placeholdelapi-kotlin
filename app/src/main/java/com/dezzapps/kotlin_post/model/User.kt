package com.dezzapps.kotlin_post.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
): Serializable