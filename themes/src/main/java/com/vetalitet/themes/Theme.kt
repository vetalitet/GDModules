package com.vetalitet.themes

import android.graphics.Color

class Theme private constructor(
    val bgColor: Int,
    val textColor: Int
) {
    data class Builder(
        var bgColor: Int = Color.GRAY,
        var textColor: Int = Color.BLACK
    ) {
        fun bgColor(bgColor: Int) = apply { this.bgColor = bgColor }
        fun textColor(textColor: Int) = apply { this.textColor = textColor }
        fun build():Theme = Theme(bgColor, textColor)
    }
}
