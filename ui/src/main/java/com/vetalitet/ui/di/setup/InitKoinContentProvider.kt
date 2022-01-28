package com.vetalitet.ui.di.setup

import com.vetalitet.ui.apiModule
import com.vetalitet.ui.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.koinApplication

class InitKoinContentProvider : EmptyContentProvider() {
    override fun onCreate(): Boolean {
        LibKoinContext.koinApplication = koinApplication {
            androidContext(context!!.applicationContext)
            modules(
                apiModule,
                viewModelModule
            )
        }
        return true
    }
}