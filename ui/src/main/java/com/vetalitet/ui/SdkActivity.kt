package com.vetalitet.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SdkActivity: AppCompatActivity(R.layout.activity_sdk) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, SdkFragment())
                .commitAllowingStateLoss()
        }
    }

}
