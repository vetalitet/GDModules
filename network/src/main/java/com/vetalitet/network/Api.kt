package com.vetalitet.network

import com.vetalitet.foundation.FoundationConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class Api {

    suspend fun getSuspendedData(): String {
        return withContext(Dispatchers.IO) {
            delay(1000)
            FoundationConstants.CONST1
        }
    }

}
