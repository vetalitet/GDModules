package com.vetalitet.ui.di.setup

import android.content.Context
import androidx.startup.Initializer
import com.vetalitet.ui.apiModule
import com.vetalitet.ui.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.dsl.koinApplication

class KoinInitializer: Initializer<KoinApplication> {
    override fun create(context: Context): KoinApplication {
        LibKoinContext.koinApplication = koinApplication {
            androidContext(context.applicationContext)
            modules(
                apiModule,
                viewModelModule
            )
        }
        return LibKoinContext.koinApplication
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}