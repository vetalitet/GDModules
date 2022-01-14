package com.vetalitet.gdmodules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vetalitet.ui.SdkFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, SdkFragment())
                .commitAllowingStateLoss()
        }
    }

}
