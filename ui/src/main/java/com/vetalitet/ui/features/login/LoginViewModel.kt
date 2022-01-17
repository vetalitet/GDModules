package com.vetalitet.ui.features.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vetalitet.network.Api
import com.vetalitet.ui.core.UiState
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginLiveData = MutableLiveData<UiState?>()
    val loginLiveData: LiveData<UiState?> = _loginLiveData

    fun login() {
        _loginLiveData.postValue(UiState.Loading)
        viewModelScope.launch {
            val result = Api().getSuspendedData()
            _loginLiveData.postValue(UiState.Success(result))
        }
    }

}
