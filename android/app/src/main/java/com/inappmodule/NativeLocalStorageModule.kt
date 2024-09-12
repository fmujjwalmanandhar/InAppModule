package com.nativeLocalStorage

import com.facebook.react.bridge.ReactApplicationContext
import android.content.Context
import android.content.SharedPreferences
import com.nativelocalstorage.NativeLocalStorageSpec

class NativeLocalStorageModule(reactContext: ReactApplicationContext) : NativeLocalStorageSpec(reactContext) {

    override fun getName(): String {
        return NAME
    }

    companion object {
        const val NAME = "NativeLocalStorage"
    }

    override fun getString(key: String): String {
        val sharedPref =
            getReactApplicationContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val username = sharedPref.getString(key, "")
        return username.toString()
    }

    override fun setString(key: String, value: String) {
        val sharedPref =
            getReactApplicationContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    override fun clear(key: String) {
        val sharedPref= getReactApplicationContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.remove(key)
        editor.apply()
    }
}