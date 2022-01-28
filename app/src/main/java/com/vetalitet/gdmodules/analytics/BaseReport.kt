package com.vetalitet.gdmodules.analytics

import java.util.concurrent.ConcurrentHashMap

open class BaseReport {

    private var properties: ConcurrentHashMap<String, String> = ConcurrentHashMap()

    //region Getter/Setter
    operator fun get(key: Property): String {
        return properties[key.content].toString()
    }

    operator fun set(key: Property, value: String) {
        properties[key.content] = value
    }
    //endregion

    sealed class Property(val content: String) {
        class CardView : Property("Card_view")
        class CardViewed : Property("Card_Viewed")
        class Attempted : Property("Attempted")
    }

    fun reportWith(handle: () -> Unit) {
        handle.invoke()
        ReportingManager.reportEvent(this)
    }

}
