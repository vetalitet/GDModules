package com.vetalitet.themes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object ThemeProvider {

    private val _theme = MutableLiveData<Theme?>()
    val theme : LiveData<Theme?> = _theme

    /**
     * maintain a HashMap of [Theme.id] and [Theme]
     */
    private var loadedThemes: Theme? = null

    /**
     * add or replace a [Theme]
     */
    fun setTheme(newTheme: Theme) {
        loadedThemes = newTheme
        _theme.postValue(loadedThemes)
    }

}
