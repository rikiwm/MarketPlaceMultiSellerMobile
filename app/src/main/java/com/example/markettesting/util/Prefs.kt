package com.example.markettesting.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class Prefs(activity: Activity) {
    private var sp:SharedPreferences? = null
    private val login = "login"

    init {
        sp = activity.getSharedPreferences("Mypren",Context.MODE_PRIVATE)
    }

    fun setLogin(value: Boolean){
        sp!!.edit().putBoolean(login, value).apply()
    }

    fun getLogin (): Boolean{
        return sp!!.getBoolean(login, false)
    }
}