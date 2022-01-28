package com.vetalitet.themes

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

object ThemeProvider {

    /*private val _theme = MutableSharedFlow<Theme>(replay = 1, extraBufferCapacity = 1)
    val theme: SharedFlow<Theme> = _theme*/

    private var _currentTheme = MutableStateFlow(Theme.Builder().build())
    val currentTheme: StateFlow<Theme> = _currentTheme

    suspend fun setTheme(newTheme: Theme) {
        delay(2500)
        _currentTheme.emit(newTheme)
        //_theme.emit(newTheme)
    }

}
