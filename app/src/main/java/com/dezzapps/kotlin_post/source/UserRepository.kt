package com.dezzapps.kotlin_post.source

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dezzapps.kotlin_post.model.User
import com.dezzapps.kotlin_post.source.services.DataServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {


    private val TAG: String = UserRepository::class.java.simpleName

    private val users: List<User> = ArrayList()

    private val mutableLiveData: MutableLiveData<List<User>> = MutableLiveData()

    fun getLiveData(context: Context): LiveData<List<User>>{
        val userDataService: DataServices = RetrofitInstance.getDataService()
        val call: Call<List<User>> = userDataService.getUsers()

        call.enqueue(object : Callback<List<User>>{
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d(TAG, "Fallo al cargar datos")
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                if(response.isSuccessful) run {
                    response.body()?.forEach {
                        Log.d(TAG, it.toString())
                    }
                    mutableLiveData.postValue(response.body())
                }

            }

        })

        return mutableLiveData
    }

}