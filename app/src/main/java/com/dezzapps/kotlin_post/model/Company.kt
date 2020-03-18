package com.dezzapps.kotlin_post.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Company(
    val bs: String,
    val catchPhrase: String,
    val name: String
): Serializable