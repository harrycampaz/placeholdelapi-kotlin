package com.dezzapps.kotlin_post.source

import com.dezzapps.kotlin_post.rest.Endpoints.Companion.URL_BASE
import com.dezzapps.kotlin_post.source.services.DataServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    fun getDataService() : DataServices {
        return Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DataServices::class.java)

    }
}