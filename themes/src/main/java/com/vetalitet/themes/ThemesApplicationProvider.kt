package com.vetalitet.themes

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.graphics.Color
import android.net.Uri
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class ThemesApplicationProvider: BaseProvider() {

    val ioScope = CoroutineScope(Dispatchers.IO)

    private val _theme = MutableSharedFlow<Theme>(replay = 1, extraBufferCapacity = 1)
    val theme : SharedFlow<Theme> = _theme

    override fun onCreate(): Boolean {
        ioScope.launch {
            //delay(2500)
            ThemeProvider.setTheme(defaultTheme())
        }
        return true
    }

    private fun defaultTheme(): Theme {
        return Theme.Builder()
            .bgColor(Color.YELLOW)
            .build()
    }

}

abstract class BaseProvider : ContentProvider(){
    override fun insert(uri: Uri, values: ContentValues?): Uri {
        throw Exception("unimplemented")
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor {
        throw Exception("unimplemented")
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        throw Exception("unimplemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        throw Exception("unimplemented")
    }

    override fun getType(uri: Uri): String {
        throw Exception("unimplemented")
    }
}