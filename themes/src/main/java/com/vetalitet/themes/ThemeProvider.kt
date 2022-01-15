package com.vetalitet.themes

import android.graphics.Color
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.withContext

object ThemeProvider {

    private val _theme = MutableSharedFlow<Theme>(replay = 1, extraBufferCapacity = 1)
    val theme : SharedFlow<Theme> = _theme

    private var loadedThemes: Theme = defaultTheme()

    suspend fun setTheme(newTheme: Theme) = withContext(Dispatchers.IO) {
        loadedThemes = newTheme
        delay(200)
        _theme.emit(loadedThemes)
    }

    private fun defaultTheme(): Theme {
        return Theme.Builder()
            .bgColor(Color.BLACK)
            .textColor(Color.WHITE)
            .build()
    }

}
