package com.supersolid.cookandme.gray5

internal class G5Router(private val routes: Map<String, () -> Unit>) {
    fun dispatch(key: String) = routes[key]?.invoke()
}
