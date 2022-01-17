package com.vetalitet.ui.utils

import androidx.databinding.BindingAdapter

import android.widget.Button
import com.vetalitet.ui.core.UiState

@BindingAdapter("isEnabled")
fun Button.isEnabled(uiState: UiState?) {
    isEnabled = uiState !is UiState.Loading
}
