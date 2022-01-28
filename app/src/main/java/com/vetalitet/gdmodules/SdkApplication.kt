package com.vetalitet.gdmodules

import android.app.Application
import android.util.Log
import com.vetalitet.themes.SdkProvider
import com.vetalitet.themes.ThemeProvider

class SdkApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("DEBUG__", "SdkApplication")
        SdkProvider.setTheme("https://filesamples.com/samples/document/txt/sample3.txt")
    }

}
