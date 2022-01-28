package com.vetalitet.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vetalitet.ui.di.setup.LibKoinComponent
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class NavigationActivity: AppCompatActivity(R.layout.activity_navigation), LibKoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
