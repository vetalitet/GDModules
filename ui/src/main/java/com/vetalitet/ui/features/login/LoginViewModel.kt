package com.vetalitet.ui.features.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vetalitet.network.Api
import com.vetalitet.ui.core.UiState
import kotlinx.coroutines.launch

class LoginViewModel(private val api: Api) : ViewModel() {

    private val _loginLiveData = MutableLiveData<UiState?>()
    val loginLiveData: LiveData<UiState?> = _loginLiveData

    private val _apiIDLiveData = MutableLiveData<String?>()
    val apiIDLiveData: LiveData<String?> = _apiIDLiveData

    fun login() {
        _loginLiveData.postValue(UiState.Loading)
        viewModelScope.launch {
            val result = api.getSuspendedData()
            _apiIDLiveData.postValue(api.toString())
            _loginLiveData.postValue(UiState.Success(result))
        }
    }

}
