package com.dezzapps.kotlin_post.model


import com.google.gson.annotations.SerializedName

data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)