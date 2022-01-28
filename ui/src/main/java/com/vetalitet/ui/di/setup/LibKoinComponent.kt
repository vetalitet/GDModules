package com.vetalitet.ui.di.setup

import org.koin.core.Koin
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
interface LibKoinComponent: KoinComponent {
    override fun getKoin(): Koin {
        return LibKoinContext.koinApplication.koin
    }
}
