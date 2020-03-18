package com.dezzapps.kotlin_post.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Geo(
    val lat: String,
    val lng: String
): Serializable