package com.dezzapps.kotlin_post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dezzapps.kotlin_post.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private val TAG: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainActivityViewModel: MainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel.getAllUser(this).observeForever(Observer{
            it.forEach {
                Log.d(TAG, it.name)
            }
        })

    }
}
