package com.vetalitet.themes

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("t_background")
fun themeBackgroundBinding(view: View, style: Any?) {
    view.setBackgroundColor(ThemeProvider.currentTheme.value.bgColor)
}