package com.vetalitet.gdmodules

import android.app.Application
import android.graphics.Color
import com.vetalitet.themes.Theme
import com.vetalitet.themes.ThemeProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SdkApplication: Application() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO + Job())

    override fun onCreate() {
        super.onCreate()
        coroutineScope.launch {
            ThemeProvider.setTheme(createTheme())
        }
    }

    private fun createTheme() = Theme.Builder()
        .bgColor(Color.DKGRAY)
        .textColor(Color.BLUE)
        .build()

}
