package com.vetalitet.ui.core

sealed class UiState {
    object Loading : UiState()
    data class Error(val message: String? = null): UiState()
    data class Success<T>(val result: T? = null): UiState()
}
