package com.vetalitet.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class Api {

    suspend fun getSuspendedData(): String {
        return withContext(Dispatchers.IO) {
            delay(5000)
            "Hello world (Coroutines)"
        }
    }

}