package com.dezzapps.kotlin_post.source

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import com.dezzapps.kotlin_post.model.Post
import com.dezzapps.kotlin_post.source.services.DataServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostsRepository {
    private val TAG: String = PostsRepository::class.java.simpleName
    private val posts: List<Post> = ArrayList()
    val params: MutableMap<String, Int> = mutableMapOf()

    private val mutableLiveData: MutableLiveData<List<Post>> = MutableLiveData()

    fun getLiveData(context: Context, userId: Int): LiveData<List<Post>> {
        val postsDataServices: DataServices = RetrofitInstance.getDataService()

        params["userId"] = userId

        val call: Call<List<Post>> = postsDataServices.getPosts(params)

        call.enqueue(object : Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d(TAG, "Fallo al cargar datos")
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                if(response.isSuccessful) run {
                    response.body()?.forEach {
                        Log.d(TAG, it.toString())
                    }

                    mutableLiveData.postValue(response.body())
                }

            }

        })

        return  mutableLiveData

    }

}