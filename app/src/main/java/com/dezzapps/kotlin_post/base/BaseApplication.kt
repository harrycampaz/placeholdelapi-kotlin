package com.dezzapps.kotlin_post.base

import android.app.Application
import android.util.Log

class BaseApplication: Application() {

    private val TAG: String = BaseApplication::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Init App")
    }
}