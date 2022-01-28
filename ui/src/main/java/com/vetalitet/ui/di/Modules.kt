package com.vetalitet.ui

import com.vetalitet.network.Api
import com.vetalitet.ui.features.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
}

val apiModule = module {
    single { Api() }
}
