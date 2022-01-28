package com.vetalitet.ui.features

import androidx.fragment.app.Fragment
import com.vetalitet.ui.di.setup.LibKoinComponent
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
open class BaseFragment: Fragment(), LibKoinComponent {
}